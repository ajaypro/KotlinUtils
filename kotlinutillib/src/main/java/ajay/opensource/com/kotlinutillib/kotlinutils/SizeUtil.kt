package ajay.opensource.com.kotlinutillib.kotlinutils

import java.io.File

/**
 * Created by Ajay Deepak on 24-12-2018.
 */


/**
 * get human-readable size string from given file
 *
 * @return human-readable string
 */

fun File.getSizeByMb(): String {
    var size: Long = 0
    if( this.exists() && this.canRead()) {
        size = this.length()
    }
    return size.toNumInUnits()
}

/**
 * Calcuate size into human-readable size
 */
fun Long.toNumInUnits(): String {
    var count = 0
    var bytes = this

    while(bytes > 1024 * 1024) {
        bytes = bytes shr 10
        count++
    }
    if(bytes > 1024){
        count++
    }

    return String.format("%.1f %cB", bytes / 1024f, " kMGTPE"[count])
}