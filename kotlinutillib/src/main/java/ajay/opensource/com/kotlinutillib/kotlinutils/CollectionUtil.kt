package ajay.opensource.com.kotlinutillib.kotlinutils

import java.util.ArrayList

/**
 * Created by Ajay Deepak on 30-12-2018.
 */



/**
 * Return an immutable list containing vararg parameter
 *
 * @param <T> the class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
fun <T> listOf(vararg items: T): List<T> = items.toList()


/**
 * Return an ArrayLIit containing vararg parameter
 *
 * @param <T> The class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
fun <T> arrayListOf(vararg items: T) = ArrayList(items.toList())

/**
 * Return an Array<T> containing vararg parameter
 *
 * @param <T> The class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
inline fun <reified T> arrayOf(vararg items: T) = items.toList().toTypedArray()