package ajay.opensource.kotlinutils

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder

/**
 * Created by Ajay Deepak on 20-12-2018.
 */
@SuppressLint("MissingPermission")
class LocationServiceUtil: Service() {

    private val gpsLocationListener = LocationChangeListener()
    private val networkLocationListener = LocationChangeListener()
    private val sensorLocationListener = SensorListener()
    private var currentKnownLocation: Location? = null

    private val TWO_MINUTES = 1000 * 60 * 2
    private val FASTEST_INTERVAL_IN_MS = 1000L
    private val bearing: Float = 0.0f
    private var locationCallback: LocationCallback? = null
    private val sensorEventListener = SensorListener()


    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        return START_STICKY

    }

    override fun onCreate() {
        super.onCreate()
        getLocationUpdates()
    }


    override fun onDestroy() {
        super.onDestroy()
        stopUpdates()
        sensorManager.unregisterListener(sensorEventListener)
    }

    private fun stopUpdates() {
        locationManager.removeUpdates(gpsLocationListener)
        locationManager.removeUpdates(networkLocationListener)
        sensorManager.unregisterListener(sensorEventListener)
    }

    /**
     * get location of user.
     * this service using 3 methods for fetch location. (Mobile, GPS, Sensor)
     */
    private fun getLocationUpdates() {

        val lastKnownGPSLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val lastKnownNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        var bestLastKnownLocation = currentKnownLocation

        if( lastKnownGPSLocation != null  && isBetterLocation(lastKnownGPSLocation, bestLastKnownLocation)) {
            bestLastKnownLocation = lastKnownGPSLocation
        }

        if( lastKnownNetworkLocation != null && isBetterLocation(lastKnownNetworkLocation, bestLastKnownLocation)) {
            bestLastKnownLocation = lastKnownNetworkLocation
        }

        currentKnownLocation = bestLastKnownLocation

        if (locationManager.allProviders.contains(LocationManager.GPS_PROVIDER) && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, FASTEST_INTERVAL_IN_MS, 0.0f, gpsLocationListener)
        }

        if (locationManager.allProviders.contains(LocationManager.NETWORK_PROVIDER) && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, FASTEST_INTERVAL_IN_MS, 0.0f, networkLocationListener)
        }

        bestLastKnownLocation?.bearing = bearing
        locationCallback?.handleNewLocation(currentKnownLocation as Location)

        /**
         * getting user device sensor information for location
         */

        val mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        sensorManager.registerListener(sensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL * 5)

    }

    private inner class LocationChangeListener: android.location.LocationListener {


        override fun onLocationChanged(location: Location?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun onProviderEnabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun onProviderDisabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private inner class SensorListener: SensorEventListener {


        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun onSensorChanged(event: SensorEvent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private fun isBetterLocation(location: Location, currentBestLocation: Location?): Boolean {
        if (currentBestLocation == null) {
            // If you have not saved anything previously
            return true
        }

        val timeDelta = location.time - currentBestLocation.time
        val isSignificantlyNewer = timeDelta > TWO_MINUTES // Time diff > 2 mins
        val isSignificantlyOlder = timeDelta < -TWO_MINUTES // time diff < 2 mins
        val isNewer = timeDelta > 0 // Identify new location information

        // If the difference is more than 2 minutes, use a new one (because the user moves)
        if (isSignificantlyNewer) {
            return true
        } else if (isSignificantlyOlder) {
            return false
        }

        // Check whether the new location fix is more or less accurate
        val accuracyDelta = (location.accuracy - currentBestLocation.accuracy).toInt()
        val isLessAccurate = accuracyDelta > 0 // Existing movements are more accurate
        val isMoreAccurate = accuracyDelta < 0 // New is more accurate
        val isSignificantlyLessAccurate = accuracyDelta > 200 // 200 or more serious differences M
        val isFromSameProvider = isSameProvider(location.provider, currentBestLocation.provider) // The same provider

        if (isMoreAccurate) {// More accurate?
            return true
        } else if (isNewer && !isLessAccurate) {// When new data is correct and new
            return true
        } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {// If it's new data and not too different and the same provider
            return true
        }
        return false
    }

    private fun isSameProvider(provider1: String?, provider2: String?): Boolean =
        if (provider1 == null) provider2 == null else provider1 == provider2

    interface LocationCallback {
        fun handleNewLocation(location: Location)
    }

}

