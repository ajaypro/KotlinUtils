package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Ajay Deepak on 11-12-2018.
 */


/**
 * give url to open a new browser
 * adding flag NEW_TASK to open new browser activity in new task which does not have any other activity on top of it
 * @return boolean value
 */

fun Context.browse(url: String, newTask: Boolean = false): Boolean {

    return try{
        val intent  = Intent(Intent.ACTION_VIEW)
         intent.data = Uri.parse(url)
        if(newTask){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        true
    } catch (e: ActivityNotFoundException){
        e.printStackTrace()
        false
    }
}

/**
 * give phone number to call
 * this requires CALL_PHONE permission
 * @return boolean value
 */

fun Context.makeCall (number: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_CALL)
        startActivity(intent)
        true
    } catch (e: ActivityNotFoundException){
        e.printStackTrace()
        false
    }
}

/**
 * give phone number to dail
 * @return boolean value
 */


fun Context.dail (number: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_DIAL)
        startActivity(intent)
        true
    } catch (e: ActivityNotFoundException){
        e.printStackTrace()
        false
    }
}