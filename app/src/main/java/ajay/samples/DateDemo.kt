package ajay.samples

import ajay.opensource.com.kotlinutillib.kotlinutils.asDateString
import ajay.opensource.com.kotlinutillib.kotlinutils.dateFromCurrentTime
import ajay.opensource.com.kotlinutillib.kotlinutils.toDateString
import android.content.Context
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


/**
 * Created by Ajay Deepak on 08-12-2018.
 */



    fun main(args: Array<String>) {
        val date1: Date? = null
        println(date1?.asDateString("dd/mm/yy"))

        //Getting date as string as desired format
        println(dateFromCurrentTime("yy-m-d"))

        //Getting date from current time
        val date: Long = System.currentTimeMillis()
        println(date.asDateString("yy-mm-dd"))

        lateinit var context: Context
        println("$context.networkCheck()")

    }
