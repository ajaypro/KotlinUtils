package ajay.opensource.kotlinutils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
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