package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context

/**
 * Created by Ajay Deepak on 04-01-2019.
 */


/**
* convert dip to px
*
* @param[value] to convert
* @return calculated dip
*/
fun Context.dip2px(value: Int): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert dip to px
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.dip2px(value: Float): Int = (value * resources.displayMetrics.density).toInt()