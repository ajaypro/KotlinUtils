package ajay.opensource.com.kotlinutillib.kotlinutils

import java.math.BigDecimal

/**
 * Created by Ajay Deepak on 28-12-2018.
 */


/**
 * safe cast String to Byte
 * @receiver String
 * @param radix Int
 * @param default Byte
 * @return Byte
 */
@JvmOverloads
fun String.safeByte(radix: Int, default: Byte = 0) : Byte = this.toByteOrNull(radix) ?: default

/**
 * safe cast String to Long
 * @receiver String
 * @param radix Int
 * @param default Long
 * @return Long
 */
@JvmOverloads
fun String.safeLong(radix: Int, default: Long = 0L) = this.toLongOrNull(radix) ?: default

/**
 * safe cast String to Float
 * @receiver String
 * @param default Float
 * @return Float
 */

@JvmOverloads
fun String.safeFloat(default: Float = 0F) = this.toFloatOrNull() ?: default

/**
 * safe cast String to Double
 * @receiver String
 * @param default Double
 * @return Double
 */

@JvmOverloads
fun String.safeDouble(default: Double = 0.0) : Double = this.toDoubleOrNull() ?: default


/**
 * safe cast String to BigDecimal
 * @receiver String
 * @param default BigDecimal
 * @return BigDecimal
 */
@JvmOverloads
fun String.safeBigDecimal(default: BigDecimal = BigDecimal.ZERO) = this.toBigDecimalOrNull() ?: default

