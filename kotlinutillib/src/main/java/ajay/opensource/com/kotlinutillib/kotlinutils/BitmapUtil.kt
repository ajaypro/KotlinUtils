package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import java.io.File

/**
 * Created by Ajay Deepak on 17-12-2018.
 */


/**
 * rotate bitmap
 *
 * @param[bitmap] Bitmap which rotate
 * @param[degree] rotate amount
 */

fun rotateBitmap(image:Bitmap, degree:Int) : Bitmap {
    val mat = Matrix()
    return Bitmap.createBitmap(image,0,0,image.width, image.height, mat, true)
}

/**
 * get bitmap from filePath
 * @return Bitmap object
 */
fun String.getBitmap(): Bitmap? = if(this.isEmpty()) null else BitmapFactory.decodeFile(this)


/**
 * Save Bitmap to given File
 */
fun File.saveBitmapToFile(bitmap:Bitmap,
                          format:Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
                          quality: Int = 100): File? {
    this.outputStream().use {
        bitmap.compress(format,quality,it)

    }

    return this
}

/**
 * Save Bitmap to generated File
 */
@JvmOverloads
fun Context.saveBitmapToFile(bitmap: Bitmap,
                             dateFormat: String = "yyyy-MM-dd HH:mm:ss",
                             format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
                             quality: Int = 100): File? {
    val file = getOutputMediaFile(dateFormat, format)
    file.saveBitmapToFile(bitmap, format, quality)
    return file
}

/**
 * Generate [File] object in externalFilesDir
 */
@JvmOverloads
fun Context.getOutputMediaFile(dateFormat: String = "yyyy-MM-dd HH:mm:ss",
                               format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG): File {
    val fileExtension = when (format) {
        Bitmap.CompressFormat.JPEG -> ".jpg"
        Bitmap.CompressFormat.PNG -> ".png"
        Bitmap.CompressFormat.WEBP -> ".webp"
    }
    val picName = dateFromCurrentTime(dateFormat) + fileExtension
    val folder = this.getExternalFilesDir(null)
    if(!folder.isDirectory) {
        folder.mkdirs()
    }

    return File(folder, picName)
}

/**
 * Request MediaScanning
 *
 * @param[url] to request
 */
fun Context.requestMediaScanning(url: String) {
    val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
    val contentUri = Uri.fromFile(File(url))
    mediaScanIntent.data = contentUri
    this.sendBroadcast(mediaScanIntent)
}

public enum class ImageOrientation{
    PORTRAIT, LANDSCAPE;
     fun getOrientation(width: Int, height: Int) : ImageOrientation {
          return if (width >= height) LANDSCAPE else PORTRAIT

     }
}