package ajay.opensource.com.kotlinutillib.kotlinutils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by Ajay Deepak on 21-12-2018.
 */
class PreferenceUtil private constructor(context: Context) {

    private val editor: SharedPreferences.Editor
    private val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    init {
        editor = pref.edit()
        editor.apply()
    }

    /**
     * put String to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: String) = editor.putString(key, value).commit()

    /**
     * put Int to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Int) = editor.putInt(key, value).commit()

    /**
     * put CharSequence to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: CharSequence) = editor.putString(key, value.toString()).commit()

    /**
     * put Boolean to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Boolean) = editor.putBoolean(key, value).commit()

    /**
     * put Long to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Long) = editor.putLong(key, value).commit()

    /**
     * put Float to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Float) = editor.putFloat(key, value).commit()

    /**
     * put Double to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Double) = editor.putString(key, value.toString() ).commit()

    /**
     * put Char to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Char) = editor.putString(key, value.toString()).commit()

    /**
     * Put any value to SharedPreference
     *
     * @param[pair] Pair of String and Any
     */

    fun put(pair: Pair<String, Any>) {
        val key = pair.first
        val value = pair.second
        when(value) {
            is String -> put(key, value)
            is Int -> put(key, value)
            is Float -> put(key, value)
            is Char -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is Long -> put(key, value)
            is CharSequence -> put(key, value)
        }
    }
    /**
     * delete key from SharedPreference
     *
     * @param[key] key of preference
     *
     */
    fun remove(key: String) = editor.remove(key).commit()

    /**
     * clear key, value based on key from SharedPreference
     *
     * @param[key] key of preference
     *
     */
    fun clear(key: String) = editor.clear().commit()

}