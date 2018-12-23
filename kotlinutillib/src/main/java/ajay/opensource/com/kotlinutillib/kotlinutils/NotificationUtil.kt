package ajay.opensource.com.kotlinutillib.kotlinutils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi

/**
 * Created by Ajay Deepak on 23-12-2018.
 */


/**
 * Create notification for android oreo and above
 *
 *
 */
@RequiresApi(Build.VERSION_CODES.O)
@JvmOverloads
fun Context.createNotification(id: String ="", name: String="", description: String="", importance: Int = NotificationManager.IMPORTANCE_HIGH ):String {
    if(Build.VERSION.SDK_INT < 23){
        return ""
    }

    val newId = id.isEmptyorReturn(this.packageName)
    val appName = if(applicationInfo.labelRes != 0) getString(applicationInfo.labelRes) else applicationInfo.nonLocalizedLabel.toString()
    val newname = name.isEmptyorReturn(appName)
    val description = description.isEmptyorReturn(appName)

    val notificationManager = this.notificationManager
    val mChannel = NotificationChannel(newId, newname,importance)
    mChannel.description = description
    notificationManager.createNotificationChannel(mChannel)

    return newId
}
