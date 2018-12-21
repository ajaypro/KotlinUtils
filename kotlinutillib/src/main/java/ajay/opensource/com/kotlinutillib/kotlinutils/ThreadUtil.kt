package ajay.opensource.com.kotlinutillib.kotlinutils

import ajay.opensource.com.kotlinutillib.interfaces.K0
import android.os.Handler
import android.os.Looper


/**
 * Created by Ajay Deepak on 13-12-2018.
 */

/**
 *  run code inside UI thread
 *  @return [code] code to execute
 */

fun runCodeonUIThread(code: () -> Unit) = Handler(Looper.getMainLooper()).post(Runnable(code))

/**
 *  run code on background thread with delay
 *  @param [delayinms] delay in ms
 *  @return [action] code to execute
 */

fun runDelayed(delayinms: Long, action: ajay.opensource.com.kotlinutillib.interfaces.K0) =
    Handler().postDelayed({action.invoke()},delayinms)

/**
 * run code inside of UI Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayedOnUiThread(action: () -> Unit, delayMillis: Long) =
    Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)



