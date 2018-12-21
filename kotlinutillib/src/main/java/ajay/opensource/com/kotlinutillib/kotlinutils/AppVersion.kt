package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context

/**
 * Created by Ajay Deepak on 12-12-2018.
 */

/**
 * get version code of this application
 * @return version code
 */
fun Context.versionCode(): Int = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionCode }, 0)

/**
 * get version name of this application
 * @return version code
 */
fun Context.versionName(): String = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionName }, "")