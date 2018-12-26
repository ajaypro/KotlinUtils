package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.MimeTypeFilter
import android.webkit.MimeTypeMap
import java.io.File

/**
 * Created by Ajay Deepak on 26-12-2018.
 */


/**
 * check uri is media uri
 * @return True if Uri is a MediaStore Uri.
 */

fun isMediaUri(uri: Uri?) : Boolean =
    if(uri != null){
        "media".equals(uri.authority, ignoreCase = false)
    }
    else false


/**
 * Convert File into Uri.
 */
fun fileToUri(file: File): Uri?  =
    if(file != null ){
        Uri.fromFile(file)
    } else null

/**
 * Gets the extension of a file name, like ".png" or ".jpg".
 */
fun Context.getMimeType(file: File): String {
    val extension = fileExtension(file.name)
    return if( extension.isNotEmpty()) MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1))
    else "application/octet-stream"
}


/**
 * Gets the extension of a file name, like ".png" or ".jpg".
 */
fun Context.fileExtension(uri: String?):String {
    if( uri == null){
        return ""
    }
    val dot = uri.lastIndexOf(".")
    return if(dot >= 0){
        uri.substring(dot)
    } else {
        ""
    }
}

/**
 * Attempt to retrieve the thumbnail of given File from the MediaStore. This
 * should not be called on the UI thread.
 */
fun Context.getThumbnail(file: File): Bitmap? {
    return thumbnail(fileToUri(file), getMimeType(file))
}

/**
 * Attempt to retrieve the thumbnail of given Uri from the MediaStore. This
 * should not be called on the UI thread.
 */
fun Context.getThumbnail(uri:Uri): Bitmap? {
    return thumbnail(uri,getMimeType(File(uri.path)))
}



/**
 * Attempt to retrieve the thumbnail of given Uri from the MediaStore. This
 * should not be called on the UI thread.
 */

fun Context.thumbnail(uri: Uri?, mimeType: String):Bitmap? {
    if(!isMediaUri(uri)){
        return null
    }

    val cursor = this.contentResolver.query(uri,null, null, null, null)
    cursor.use {
        val results = generateSequence { if(cursor.moveToNext()) cursor else null }.map {
            val id = it.getInt(0)
            when {
                mimeType.contains("video") -> MediaStore.Video.Thumbnails.getThumbnail(contentResolver,id.toLong(),MediaStore.Video.Thumbnails.MICRO_KIND, null)
                mimeType.contains("image") -> MediaStore.Video.Thumbnails.getThumbnail(contentResolver,id.toLong(),MediaStore.Video.Thumbnails.MINI_KIND,null)
                else -> null
            }
        }.filter { it != null }.toList()
       return if(results.isNotEmpty()){
            results[0]
        } else
            null
    }



}
