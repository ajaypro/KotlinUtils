package ajay.opensource.kotlinutils

import android.app.ActivityManager
import android.content.Context

/**
 * Created by Ajay Deepak on 17-12-2018.
 */


/**
 * get boolean value for whatever application process is running
 *
 * @return true - FOREGROUND
 */
fun Context.isProcessRunning()
    = activityManager.runningAppProcesses.filter { it.processName.equals(packageName, true) }
        .map { it.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND }
