package specodec.ryu

import RyuMath._

val DOUBLE_MANTISSA_BITS: Int = 52
val DOUBLE_BIAS: Int = 1023
val DOUBLE_POW5_INV_BITCOUNT: Int = 125
val DOUBLE_POW5_BITCOUNT: Int = 125

def float64ToString(d: Double): String = {
  val bits = java.lang.Double.doubleToRawLongBits(d)

  val sign = (bits >>> 63) != 0L
  val ieeeMantissa = bits & 0xFFFFFFFFFFFFFL
  val ieeeExponent = ((bits >>> 52) & 0x7FFL).toInt

  if (ieeeExponent == 2047) {
    if (ieeeMantissa == 0L) {
      return if (sign) "-Infinity" else "Infinity"
    }
    return "NaN"
  }
  if (ieeeExponent == 0 && ieeeMantissa == 0L) {
    return if (sign) "-0E0" else "0E0"
  }

  var e2: Int = 0
  var m2: Long = 0L
  if (ieeeExponent == 0) {
    e2 = 1 - DOUBLE_BIAS - DOUBLE_MANTISSA_BITS - 2
    m2 = ieeeMantissa
  } else {
    e2 = ieeeExponent - DOUBLE_BIAS - DOUBLE_MANTISSA_BITS - 2
    m2 = (1L << DOUBLE_MANTISSA_BITS) | ieeeMantissa
  }

  val even = (m2 & 1L) == 0L
  val acceptBounds = even

  val mv = m2 * 4L
  val mp = mv + 2L
  var mmShift = 0L
  if (ieeeMantissa != 0L || ieeeExponent <= 1) {
    mmShift = 1L
  }
  val mm = mv - 1L - mmShift

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
    val k = DOUBLE_POW5_INV_BITCOUNT + pow5bits(q) - 1
    val i = -e2 + q + k

    vr = mulShift64(mv, DOUBLE_POW5_INV_SPLIT(q), i)
    vp = mulShift64(mp, DOUBLE_POW5_INV_SPLIT(q), i)
    vm = mulShift64(mm, DOUBLE_POW5_INV_SPLIT(q), i)

    if (q != 0 && (vp - 1L) / 10L <= vm / 10L) {
      val l = DOUBLE_POW5_INV_BITCOUNT + pow5bits(q - 1) - 1
      lastDigit = mulShift64(
        mv,
        DOUBLE_POW5_INV_SPLIT(q - 1),
        -e2 + q - 1 + l
      ) % 10L
    }

    if (q <= 21) {
      if (mv % 5L == 0L) {
        vrIsTrailingZeros = multipleOfPowerOf5_64(mv, q)
      } else if (acceptBounds) {
        vmIsTrailingZeros = multipleOfPowerOf5_64(mm, q)
      } else {
        if (multipleOfPowerOf5_64(mp, q)) {
          vp -= 1L
        }
      }
    }
  } else {
    val q = log10Pow5(-e2)
    e10 = q + e2
    val i = -e2 - q
    val k = pow5bits(i) - DOUBLE_POW5_BITCOUNT
    val j = q - k

    vr = mulShift64(mv, DOUBLE_POW5_SPLIT(i), j)
    vp = mulShift64(mp, DOUBLE_POW5_SPLIT(i), j)
    vm = mulShift64(mm, DOUBLE_POW5_SPLIT(i), j)

    if (q != 0 && (vp - 1L) / 10L <= vm / 10L) {
      val j2 = q - 1 - (pow5bits(i + 1) - DOUBLE_POW5_BITCOUNT)
      lastDigit = mulShift64(mv, DOUBLE_POW5_SPLIT(i + 1), j2) % 10L
    }

    if (q <= 1) {
      vrIsTrailingZeros = true
      if (acceptBounds) {
        vmIsTrailingZeros = mmShift == 1L
      } else {
        vp -= 1L
      }
    } else if (q < 63) {
      vrIsTrailingZeros = multipleOfPowerOf2_64(mv, q - 1)
      if (acceptBounds) {
        vmIsTrailingZeros = multipleOfPowerOf5_64(mm, q)
      } else {
        if (multipleOfPowerOf5_64(mp, q)) {
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
    val olength = decimalLength17(output)

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
    val olength = decimalLength17(output)

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
