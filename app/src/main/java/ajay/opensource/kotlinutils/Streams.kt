package ajay.opensource.kotlinutils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.InputStream

/**
 * Created by Ajay Deepak on 06-12-2018.
 */

/**
 * Extension function of InputStream class to get string
 *
 * get response string from InputStream
 * @return response string
 */


    fun InputStream.getString(): String = this.bufferedReader().use {
        it.readText()
    }

    /**
     * write file from InputStream
     *
     * @param[file] to write File object
     * @return File object which given as parameter
     */

    fun InputStream.outAsFile(file: File): File {
        file.createNewFile()

        use { input ->
            file.outputStream().use { fileOut ->
                input.copyTo(fileOut)
            }
        }

        return file
    }

    /**
     * get Bitmap from InputStream
     * @return Bitmap object
     */

    @JvmOverloads
    fun InputStream.getBitmap(): Bitmap = use {
        BitmapFactory.decodeStream(it)
    }
