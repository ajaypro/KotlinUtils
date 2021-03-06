package ajay.opensource.com.kotlinutillib.kotlinutils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.NotificationManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.Context
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by Ajay Deepak on 09-12-2018.
 */


inline val Context.notificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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

/**
 * get AppWidgetManager
 */
inline val Context.appWidgetManager
       @SuppressLint("InlineApi")
       get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

/**
 * get AudioManager
 */
inline val Context.audioManager
       @SuppressLint("InlineApi")
       get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

/**
 * get Battery Manager
 */
inline val Context.batteryManager
        @SuppressLint("InlineApi")
       get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

/**
 * get BluetoothManager
 */
inline val Context.bluetoothManager
    @SuppressLint("InlineApi")
      get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

/**
 * get CameraManager
 */
inline val Context.cameraManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

/**
 * get DisplayManager
 */
inline val Context.displayManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager


/**
 * get LocationManager
 */
inline val Context.locationManager
    @SuppressLint("InlinedApi")
      get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager


/**
 * get SensorManager
 */
inline val Context.sensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager


inline val Context.windowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

