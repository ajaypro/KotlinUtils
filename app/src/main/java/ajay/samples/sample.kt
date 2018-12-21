package ajay.samples

import ajay.opensource.com.kotlinutillib.kotlinutils.asDateString
import android.content.Context
import java.util.*

/**
 * Created by Ajay Deepak on 12-12-2018.
 */

fun main(args: Array<String>){
    println("Hello World")

    val date1: Date? = null
    println(date1?.asDateString("dd/mm/yy"))


}
