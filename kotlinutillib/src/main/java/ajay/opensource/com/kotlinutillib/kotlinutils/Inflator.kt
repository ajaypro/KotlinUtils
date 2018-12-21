package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ajay Deepak on 09-12-2018.
 */


/**
 * inflate view
 *
 * @param[layoutRes]    layout resource to inflate
 * @param[parent]       Optional view to be the parent of the generated hierarchy (if attachToRoot is true),
 *                      or else simply an object that provides a set of LayoutParams values for root of the returned hierarchy
 *                      (if attachToRoot is false.)
 *                      This value may be null.
 * @param[attachToRoot] Whether the inflated hierarchy should be attached to the root parameter?
 *                      If false, root is only used to create the correct subclass of LayoutParams for
 *                      the root view in the XML.
 * @return The root View of the inflated hierarchy.
 */
@JvmOverloads

fun Context.inflate(layoutRes: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View =
    LayoutInflater.from(this).inflate(layoutRes, parent, attachToRoot)