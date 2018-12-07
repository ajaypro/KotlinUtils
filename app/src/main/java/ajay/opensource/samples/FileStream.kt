package ajay.opensource.samples

import java.io.InputStream
import ajay.opensource.kotlinutils.*
import java.io.ByteArrayInputStream

/**
 * Created by Ajay Deepak on 07-12-2018.
 */


fun main(args: Array<String>){

    val data: InputStream = ByteArrayInputStream("Kotlin is great".toByteArray())

    val response = data.getString()

    println(response)
}