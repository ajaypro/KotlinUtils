package ajay.opensource.com.kotlinutillib.kotlinutils

import android.text.TextUtils

/**
 * Created by Ajay Deepak on 12-12-2018.
 */

/**
 * get empty string or nothing
 * @param default value as "" or leave it blank
 */

@JvmOverloads
fun String.isEmptyorReturn(str: String = "")  = if(TextUtils.isEmpty(this)) str else this

/**
 * Returns `true` if at least one element matches condition of contains string
 */
fun anyContainsString(str: String, items: Array<String>) : Boolean =
        items.any { str.contains(it, false) }

/**
 * checking string is empty
 */

fun String.isEmpty() : Boolean = TextUtils.isEmpty(this)



/**
 * returns 'true' atleast one element matches given regex condition
 */
fun containsRegex(regex: Regex, items: List<String>) : Boolean =
          items.any { it.contains(regex) }

/**
 *  Test string equals all condition of items
 */
fun allEquals(str: String, vararg items: String) : Boolean {
      return items.map { str == it }.all { true }
}

/**
 *  Test string equals any condition of items
 */
fun anyEquals(str: String, vararg items: String) : Boolean {
    return items.map { str == it }.any { true }
}

/**
 * Test 'str' contains all condition of 'items'
 */
fun allConditions(str: String, vararg items : String) : Boolean {
    return items.map { str.contains(it, true) }.all { true }
}

/**
* Test 'str' contains any condition of 'items'
*/
fun anyConditions(str: String, vararg items : String) : Boolean {
    return items.map { str.contains(it, true) }.any { true }
}

/**
 * Test whether all items are empty
 */
fun allEmpty(vararg items: String) : Boolean {
    return items.map { it.isEmpty() }.all { true }
}

/**
 * Test whether all items are not empty
 */
fun allNotEmpty(vararg items: String) : Boolean {
    return items.map { it.isNotEmpty() }.all { true }
}


