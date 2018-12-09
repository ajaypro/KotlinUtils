package ajay.opensource.samples

import ajay.opensource.kotlinutils.asDateString
import ajay.opensource.kotlinutils.dateFromCurrentTime
import ajay.opensource.kotlinutils.toDateString
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


/**
 * Created by Ajay Deepak on 08-12-2018.
 */


    fun main(args: Array<String>) {
        val date1:Date =
        println(date1.asDateString("dd/mm/yy"))

        //Getting date as string as desired format
        println(dateFromCurrentTime("yy-m-d"))

       //Getting date from current time
       val date: Long = System.currentTimeMillis()
        println(date.asDateString("yy-mm-dd"))

    }
