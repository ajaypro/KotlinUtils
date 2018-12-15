package ajay.opensource.kotlinutils

import android.content.Context
import android.content.res.AssetManager
import java.nio.charset.Charset

/**
 * Created by Ajay Deepak on 15-12-2018.
 */


/**
 * get String from Assets file
 *
 * @param[subdirectory] name of directory
 * @param[filename] name of file
 * @return String object
 */

 fun AssetManager.fileAsString(subDirectory: String, filename: String): String {
    return open("$subDirectory/$filename").use {
        it.readBytes().toString(Charset.defaultCharset())
    }
}

/**
 * get File list of specific folder in Assets
 *
 * @param[subdirectory] name of directory
 * @return list of file name
 */

 @JvmName("asAssetList")
 fun AssetManager.fileList(subDirectory: String)  = list(subDirectory).toList()


private fun Context.copyFile(filename: String) {
    this.assets.open(filename).use { stream ->
        "${this.getExternalFilesDir(null)}/$filename".toFile()
            .outputStream()
            .use { stream.copyTo(it) }
    }
}