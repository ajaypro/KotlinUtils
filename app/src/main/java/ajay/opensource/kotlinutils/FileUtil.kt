package ajay.opensource.kotlinutils

import java.io.File
import java.nio.charset.Charset

/**
 * Created by Ajay Deepak on 15-12-2018.
 */

fun String.toFile() = File(this)

/**
 * read file to string
 */
fun File.readFile():String = this.readText(Charset.defaultCharset())

/**
 * Test given path is exists and can read
 */
fun String.isFileExist(): Boolean = File(this).exists() && File(this).canRead()

/**
 * get extensions of given file path
 */
fun String.getFileExtension(): String {
    val lastPoi = this.lastIndexOf('.')
    val lastSep = this.lastIndexOf(File.separator)
    return if (lastPoi == -1 || lastSep >= lastPoi) "" else this.substring(lastPoi + 1)
}