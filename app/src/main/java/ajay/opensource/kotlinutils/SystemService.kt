package ajay.opensource.kotlinutils

import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Created by Ajay Deepak on 09-12-2018.
 */


/**
 * get InputMethodManager
 */
 inline val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

