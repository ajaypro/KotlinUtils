package ajay.opensource.com.kotlinutillib.kotlinutils

/**
 * Created by Ajay Deepak on 12-12-2018.
 */

internal inline fun <R> getValue(block: () -> R, def: Any?): R =
    try {
        block()
    } catch (e: Exception) {
        def as R
    }