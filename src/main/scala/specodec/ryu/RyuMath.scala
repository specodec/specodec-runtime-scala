package specodec.ryu

object RyuMath {
  def pow5bits(e: Int): Int = e * 1217359 / 524288 + 1
  def log10Pow2(e: Int): Int = e * 78913 / 262144
  def log10Pow5(e: Int): Int = e * 732923 / 1048576

  def decimalLength17(v: Long): Int = {
    if (java.lang.Long.compareUnsigned(v, 10000000000000000L) >= 0) return 17
    if (java.lang.Long.compareUnsigned(v, 1000000000000000L) >= 0) return 16
    if (java.lang.Long.compareUnsigned(v, 100000000000000L) >= 0) return 15
    if (java.lang.Long.compareUnsigned(v, 10000000000000L) >= 0) return 14
    if (java.lang.Long.compareUnsigned(v, 1000000000000L) >= 0) return 13
    if (java.lang.Long.compareUnsigned(v, 100000000000L) >= 0) return 12
    if (java.lang.Long.compareUnsigned(v, 10000000000L) >= 0) return 11
    if (java.lang.Long.compareUnsigned(v, 1000000000L) >= 0) return 10
    if (java.lang.Long.compareUnsigned(v, 100000000L) >= 0) return 9
    if (java.lang.Long.compareUnsigned(v, 10000000L) >= 0) return 8
    if (java.lang.Long.compareUnsigned(v, 1000000L) >= 0) return 7
    if (java.lang.Long.compareUnsigned(v, 100000L) >= 0) return 6
    if (java.lang.Long.compareUnsigned(v, 10000L) >= 0) return 5
    if (java.lang.Long.compareUnsigned(v, 1000L) >= 0) return 4
    if (java.lang.Long.compareUnsigned(v, 100L) >= 0) return 3
    if (java.lang.Long.compareUnsigned(v, 10L) >= 0) return 2
    1
  }

  def decimalLength9(v: Int): Int = {
    val uv = v & 0xFFFFFFFFL
    if (uv >= 100000000L) return 9
    if (uv >= 10000000L) return 8
    if (uv >= 1000000L) return 7
    if (uv >= 100000L) return 6
    if (uv >= 10000L) return 5
    if (uv >= 1000L) return 4
    if (uv >= 100L) return 3
    if (uv >= 10L) return 2
    1
  }

  def mulShift32(m: Long, factor: Long, shift: Int): Long = {
    val factorLo = factor & 0xFFFFFFFFL
    val factorHi = factor >>> 32
    val bits0 = m * factorLo
    val bits1 = m * factorHi
    val sumVal = (bits0 >>> 32) + bits1
    (sumVal >>> (shift - 32)) & 0xFFFFFFFFL
  }

  def mulShift64(m: Long, mul: Array[Long], shift: Int): Long = {
    val r0 = umul128(m, mul(0))
    val hi0 = r0._1
    val r1 = umul128(m, mul(1))
    val hi2 = r1._1; val lo2 = r1._2

    val sumLo = lo2 + hi0
    val carry = if (java.lang.Long.compareUnsigned(sumLo, lo2) < 0) 1L else 0L
    val sumHi = hi2 + carry

    val shiftAmount = shift - 64
    if (shiftAmount >= 128) return 0L
    if (shiftAmount >= 64) return sumHi >>> (shiftAmount - 64)
    if (shiftAmount == 0) return sumLo
    (sumHi << (64 - shiftAmount)) | (sumLo >>> shiftAmount)
  }

  def umul128(a: Long, b: Long): (Long, Long) = {
    val aLo = a & 0xFFFFFFFFL
    val aHi = a >>> 32
    val bLo = b & 0xFFFFFFFFL
    val bHi = b >>> 32

    val ll = aLo * bLo
    val lh = aLo * bHi
    val hl = aHi * bLo
    val hh = aHi * bHi

    val mid = lh + hl
    val overflow = if (java.lang.Long.compareUnsigned(mid, lh) < 0) 1L else 0L

    var hi = hh + (mid >>> 32) + overflow
    val lo = ll + ((mid & 0xFFFFFFFFL) << 32)
    if (java.lang.Long.compareUnsigned(lo, ll) < 0) hi += 1

    (hi, lo)
  }

  def multipleOfPowerOf5_64(value: Long, q: Int): Boolean = {
    if (q == 0) return true
    if (q >= 64) return value == 0L
    var pow5: Long = 5
    for (i <- 1 until q) pow5 *= 5
    java.lang.Long.remainderUnsigned(value, pow5) == 0L
  }

  def multipleOfPowerOf2_64(value: Long, q: Int): Boolean = {
    if (q == 0) return true
    if (q >= 64) return value == 0L
    (value & ((1L << q) - 1L)) == 0L
  }

  def multipleOfPowerOf5_32(value: Int, q: Int): Boolean = {
    if (q == 0) return true
    if (q >= 32) return value == 0
    var pow5: Int = 5
    for (i <- 1 until q) pow5 *= 5
    java.lang.Integer.remainderUnsigned(value, pow5) == 0
  }

  def multipleOfPowerOf2_32(value: Int, q: Int): Boolean = {
    if (q == 0) return true
    if (q >= 32) return (value & 0xFFFFFFFFL) == 0L
    val mask = (1L << q) - 1
    (value & mask) == 0
  }
}
