package ajay.opensource.com.kotlinutillib.kotlinutils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Created by Ajay Deepak on 09-12-2018.
 */

/**
 * hideKeyboard
 */

fun Activity.hideKeyboard() {
    this.currentFocus.let {
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

/**
 * hide keyboard
 */

fun Dialog.hideKeyboard() {
    this.currentFocus.let {
        this.context.inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

/**
 * toggle keyboard open / close
 */

fun Context.toggleKeyboard() {
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS)
}