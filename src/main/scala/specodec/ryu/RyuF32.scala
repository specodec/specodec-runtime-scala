package specodec.ryu

import RyuMath._

val FLOAT_MANTISSA_BITS: Int = 23
val FLOAT_BIAS: Int = 127
val FLOAT_POW5_INV_BITCOUNT: Int = 59
val FLOAT_POW5_BITCOUNT: Int = 61

def float32ToString(f: Float): String = {
  val bits = java.lang.Float.floatToRawIntBits(f)

  val sign = (bits >>> 31) != 0
  val ieeeMantissa = bits & 0x7FFFFF
  val ieeeExponent = (bits >>> 23) & 0xFF

  if (ieeeExponent == 255) {
    if (ieeeMantissa == 0) {
      return if (sign) "-Infinity" else "Infinity"
    }
    return "NaN"
  }
  if (ieeeExponent == 0 && ieeeMantissa == 0) {
    return if (sign) "-0E0" else "0E0"
  }

  var e2: Int = 0
  var m2: Long = 0L
  if (ieeeExponent == 0) {
    e2 = 1 - FLOAT_BIAS - FLOAT_MANTISSA_BITS - 2
    m2 = ieeeMantissa.toLong
  } else {
    e2 = ieeeExponent - FLOAT_BIAS - FLOAT_MANTISSA_BITS - 2
    m2 = ((1 << FLOAT_MANTISSA_BITS) | ieeeMantissa).toLong
  }

  val even = (m2 & 1L) == 0L
  val acceptBounds = even

  val mv = m2 * 4L
  val mp = mv + 2L
  var mmShift = 0
  if (ieeeMantissa != 0 || ieeeExponent <= 1) {
    mmShift = 1
  }
  val mm = mv - 1L - mmShift.toLong

  var vrIsTrailingZeros = false
  var vmIsTrailingZeros = false
  var lastDigit = 0L
  var e10: Int = 0
  var vr: Long = 0L
  var vp: Long = 0L
  var vm: Long = 0L

  if (e2 >= 0) {
    val q = log10Pow2(e2)
    e10 = q
    val k = FLOAT_POW5_INV_BITCOUNT + pow5bits(q) - 1
    val i = -e2 + q + k

    vr = mulShift32(mv, FLOAT_POW5_INV_SPLIT(q) + 1L, i)
    vp = mulShift32(mp, FLOAT_POW5_INV_SPLIT(q) + 1L, i)
    vm = mulShift32(mm, FLOAT_POW5_INV_SPLIT(q) + 1L, i)

    if (q != 0 && (vp - 1L) / 10L <= vm / 10L) {
      val l = FLOAT_POW5_INV_BITCOUNT + pow5bits(q - 1) - 1
      lastDigit = mulShift32(
        mv,
        FLOAT_POW5_INV_SPLIT(q - 1) + 1L,
        -e2 + q - 1 + l
      ) % 10L
    }

    if (q <= 9) {
      if (mv % 5L == 0L) {
        vrIsTrailingZeros = multipleOfPowerOf5_32(mv.toInt, q)
      } else if (acceptBounds) {
        vmIsTrailingZeros = multipleOfPowerOf5_32(mm.toInt, q)
      } else if (multipleOfPowerOf5_32(mp.toInt, q)) {
        vp -= 1L
      }
    }
  } else {
    val q = log10Pow5(-e2)
    e10 = q + e2
    val i = -e2 - q
    val k = pow5bits(i) - FLOAT_POW5_BITCOUNT
    val j = q - k

    vr = mulShift32(mv, FLOAT_POW5_SPLIT(i), j)
    vp = mulShift32(mp, FLOAT_POW5_SPLIT(i), j)
    vm = mulShift32(mm, FLOAT_POW5_SPLIT(i), j)

    if (q != 0 && (vp - 1L) / 10L <= vm / 10L) {
      val j2 = q - 1 - (pow5bits(i + 1) - FLOAT_POW5_BITCOUNT)
      lastDigit = mulShift32(mv, FLOAT_POW5_SPLIT(i + 1), j2) % 10L
    }

    if (q <= 1) {
      vrIsTrailingZeros = true
      if (acceptBounds) {
        vmIsTrailingZeros = mmShift == 1
      } else {
        vp -= 1L
      }
    } else if (q < 31) {
      vrIsTrailingZeros = multipleOfPowerOf2_32(mv.toInt, q - 1)
      if (acceptBounds) {
        vmIsTrailingZeros = multipleOfPowerOf5_32(mm.toInt, q)
      } else {
        if (multipleOfPowerOf5_32(mp.toInt, q)) {
          vp -= 1L
        }
      }
    }
  }

  var removed = 0
  var vr2 = vr
  var vp2 = vp
  var vm2 = vm

  if (vmIsTrailingZeros || vrIsTrailingZeros) {
    while (vp2 / 10L > vm2 / 10L) {
      vmIsTrailingZeros = vmIsTrailingZeros && (vm2 % 10L == 0L)
      vrIsTrailingZeros = vrIsTrailingZeros && (lastDigit == 0L)
      lastDigit = vr2 % 10L
      vr2 /= 10L
      vp2 /= 10L
      vm2 /= 10L
      removed += 1
    }

    if (vmIsTrailingZeros) {
      while (vm2 % 10L == 0L) {
        vrIsTrailingZeros = vrIsTrailingZeros && (lastDigit == 0L)
        lastDigit = vr2 % 10L
        vr2 /= 10L
        vp2 /= 10L
        vm2 /= 10L
        removed += 1
      }
    }

    if (vrIsTrailingZeros && lastDigit == 5L && (vr2 & 1L) == 0L) {
      lastDigit = 4L
    }

    val roundUp =
      (vr2 == vm2 && (!acceptBounds || !vmIsTrailingZeros)) || lastDigit >= 5L
    var output = vr2
    if (roundUp) {
      output += 1L
    }
    val exp = e10 + removed
    val olength = decimalLength9(output.toInt)

    var result = ""
    if (sign) result = "-"
    val digits = output.toString
    if (olength == 1) {
      result += digits
    } else {
      result += digits.substring(0, 1) + "." + digits.substring(1)
    }
    result += "E" + (exp + olength - 1).toString
    result
  } else {
    while (vp2 / 10L > vm2 / 10L) {
      lastDigit = vr2 % 10L
      vr2 /= 10L
      vp2 /= 10L
      vm2 /= 10L
      removed += 1
    }

    var output = vr2
    if (vr2 == vm2 || lastDigit >= 5L) {
      output += 1L
    }
    val exp = e10 + removed
    val olength = decimalLength9(output.toInt)

    var result = ""
    if (sign) result = "-"
    val digits = output.toString
    if (olength == 1) {
      result += digits
    } else {
      result += digits.substring(0, 1) + "." + digits.substring(1)
    }
    result += "E" + (exp + olength - 1).toString
    result
  }
}
