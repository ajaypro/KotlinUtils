package ajay.opensource.samples

import ajay.opensource.kotlinutils.asDateString
import ajay.opensource.kotlinutils.dateFromCurrentTime
import ajay.opensource.kotlinutils.toDateString


/**
 * Created by Ajay Deepak on 08-12-2018.
 */


    fun main(args: Array<String>) {

        //Getting date from current time
        println(dateFromCurrentTime("yy-m-d"))

       //Getting date from current time
       val date: Long = System.currentTimeMillis()
        println(date.asDateString("yy-mm-dd"))

    }
