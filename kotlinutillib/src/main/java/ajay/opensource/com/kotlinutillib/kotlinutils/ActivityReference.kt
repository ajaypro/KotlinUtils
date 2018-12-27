package ajay.opensource.com.kotlinutillib.kotlinutils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by Ajay Deepak on 27-12-2018.
 */


object ActivityReference {

    private var activityReference: WeakReference<Activity>? = null
    private var applicationReference: WeakReference<Application>? = null
    private var activityList: LinkedList<Activity?> = LinkedList()

    private val mCallbacks = object : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activityList.add(activity)
            setTopActivityWeakRef(activity)
        }

        override fun onActivityStarted(activity: Activity) {
            setTopActivityWeakRef(activity)
        }

        override fun onActivityResumed(activity: Activity) {
            setTopActivityWeakRef(activity)
        }

        override fun onActivityPaused(activity: Activity?) {}
        override fun onActivityStopped(activity: Activity?) {}
        override fun onActivityDestroyed(activity: Activity?) {
            activityList.remove(activity)
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }
    }

    fun setTopActivityWeakRef(activity: Activity) {
        if (activityReference == null || activity != (activityReference as WeakReference<Activity>).get())
            activityReference = WeakReference(activity)
    }

    @JvmStatic
    fun initialize(application: Application) {
        applicationReference = WeakReference(application)
        application.registerActivityLifecycleCallbacks(mCallbacks)
    }
    @JvmStatic
    fun getActivityReference(): Activity? {
        if (activityReference != null) {
            val activity = (activityReference as WeakReference<Activity>).get()
            if (activity != null) {
                return activity
            }
        }

        val size = activityList.size
        return if (size > 0) activityList[size -1] else null
    }
}