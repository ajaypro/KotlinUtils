package ajay.opensource.kotlinutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Created by Ajay Deepak on 10-12-2018.
 */

/**
 * get network connection check
 *
 * if wifi is connected, will return 1
 * if mobile  is connect, will return 0
 * else, return 2
 * Using NetworkCapabilities for API28 if your using < API28 use ConnectivityManager
 * @return network state (check legend above)
 */

fun Context.networkCheck (): Int {
    val data = connectivityManager.activeNetworkInfo ?: return 2

    return when (data.subtype){
        NetworkCapabilities.TRANSPORT_WIFI -> 1
        NetworkCapabilities.TRANSPORT_CELLULAR -> 0
        else -> 2
    }

}

/**
 * get Wifi connection check
 */

fun Context.isWifiConnected(): Boolean  = networkCheck() == 1

/**
 * get Mobile connection check
 */

fun Context.isMobileconnected(): Boolean = networkCheck() == 0

/**
 * get state of not connected
 */

fun Context.isNotConnected(): Boolean = isConnected().not()

/**
 * get state of connected
 */

fun Context.isConnected(): Boolean = networkCheck() != 2