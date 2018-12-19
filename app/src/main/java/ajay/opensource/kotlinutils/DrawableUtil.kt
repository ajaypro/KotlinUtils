package ajay.opensource.kotlinutils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

/**
 * Created by Ajay Deepak on 19-12-2018.
 */



/**
 * Bitmap to Drawable
 *
 * @param[bitmap] to convert
 * @return Drawable Object
 */
fun Context.bitmapToDrawable(bitmap: Bitmap): Drawable = BitmapDrawable(this.resources, bitmap)