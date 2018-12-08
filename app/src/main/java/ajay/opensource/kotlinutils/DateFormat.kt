package ajay.opensource.kotlinutils

import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ajay Deepak on 08-12-2018.
 */

/**
 * format date with DateFormat string
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2017-06-02 19:20:00)
 * @return Formatted Date
 */
fun Date.asDateString(format: String? = "yyyy-MM-dd HH:mm:ss"): String =
    SimpleDateFormat(format, Locale.getDefault()).format(this)

/**
 * get readable string of given timestamp.
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2017-06-02 19:20:00)
 * @return Formatted Date
 */

fun Long.asDateString(format: String? = "yyyy-MM-dd HH:mm:ss"): String =
    Date(this).asDateString(format)

/**
 * generate Date String in currentTImeMillis by giving the format you want
 *
 * @param[format] optional. default is yyyy-MM-dd HH:mm:ss (2018-012-12 09:20:00)
 *
 */

@JvmOverloads
fun dateFromCurrentTime(format: String? = "yyyy-MM-dd HH:mm:ss") =
    System.currentTimeMillis().asDateString(format)


fun String.toDateString(fromFormat: String, toFormat: String): String {
    val result: String
    val df = SimpleDateFormat(fromFormat, Locale( System.currentTimeMillis().toString()))
    val df1 = SimpleDateFormat(toFormat, Locale( System.currentTimeMillis().toString()))
    try {
        result = df1.format(df.parse(this))
    } catch (e: ParseException) {
        return this
    }
    return result
}