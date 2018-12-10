package ajay.opensource.kotlinutils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.SigningInfo
import android.util.Base64
import android.util.Log
import java.lang.Exception
import java.security.MessageDigest
import java.util.*

/**
 * Created by Ajay Deepak on 10-12-2018.
 *
 * get key hash of application
 * it will help to integrate with Facebook
 * @return key hash of application
 */



@SuppressLint("PackageManagerGetSignatures")
fun Context.getKeyHash (): String {
    val hashList: ArrayList<String> = ArrayList()
    try {
        val info = this.packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
        for (signature in info.signingInfo.apkContentsSigners) {
            val md = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            hashList.add( String(Base64.encode(md.digest(), 0)))
        }
    } catch (e: Exception){

        Log.e("tag", "I/O Exception", e)
        throw e

    }
    return if(hashList.isEmpty()) hashList[0] else ""
}