package ajay.opensource.kotlinutils

import android.app.ActivityManager
import android.content.Context
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by Ajay Deepak on 09-12-2018.
 */


/**
 * get InputMethodManager
 */
 inline val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

/**
 * get ConnectivityManager
 */
 inline val Context.connectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * get ActivityManager
 */
 inline val Context.activityManager
       get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

