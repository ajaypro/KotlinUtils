package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.Toast

/**
 * Created by Ajay Deepak on 14-12-2018.
 */


/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
@JvmOverloads // As we are giving a default value to parameters
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this,message,length)

/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
@JvmOverloads
fun Context.toast(message: Int, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this,message,length)

/**
 * Display AlertDialog instantly
 *
 * @param[title] optional, title
 * @param[message] to display
 * @param[positiveButton] optional, button text
 * @param[cancelable] able to cancel
 * @param[callback] callback of click ok button
 */

@JvmOverloads
fun Context.alert(title:String = "", cancelable: Boolean = true, positiveButton:String? = null, message: String, callback: (DialogInterface) -> Unit = {}) {

    AlertDialog.Builder(this).apply {
        if(title.isEmpty().not())
            setTitle(title)
        setMessage(message)
        setPositiveButton(positiveButton ?:getString(android.R.string.ok),{dialog, _ -> callback(dialog)  })
        setCancelable(cancelable)
        show()
    }
}


