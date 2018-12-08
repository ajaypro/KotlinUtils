package ajay.opensource.samples

import java.io.InputStream
import ajay.opensource.kotlinutils.*
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.File

/**
 * Created by Ajay Deepak on 07-12-2018.
 */


fun main(args: Array<String>){

    val data: InputStream = ByteArrayInputStream("Kotlin is great".toByteArray())
    val response = data.getString()
    println(response)


    // Writing to external file
    val value: InputStream = BufferedInputStream("Kotlin is good".byteInputStream())
    value.outAsFile(File("out your file path"))



}