package com.gautamgelani.roomdemo.sharedpreference

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.gautamgelani.roomdemo.constant.AppConstant
import com.gautamgelani.roomdemo.data.model.user.UserLoginDetail
import com.gautamgelani.roomdemo.utils.MyApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.logger.Logger

object SharedPreference {

    val sp: SharedPreferences
    private val editor: SharedPreferences.Editor
    private const val MM_secrets = "secrets"

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    init {
        sp = EncryptedSharedPreferences.create(
            MM_secrets,
            masterKeyAlias,
            MyApplication.context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        editor = sp.edit()
    }

    // ********** clear prefrences **********//
    fun clearPreferences() {
        editor.clear()
        editor.apply()
    }

    // ********** set string prefrences **********//
    fun setStringInPref(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getStringFromPref(key: String?): String? {
        return getStringFromPref(key, null)
    }

    fun getStringFromPref(key: String?, defaultValue: String?): String? {
        return sp.getString(key, defaultValue)
    }

    // ********** Int **********//
    fun setIntInPref(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    fun getIntInPref(key: String?): Int {
        return getIntInPref(key, -1)
    }

    fun getIntInPref(key: String?, defaultValue: Int): Int {
        return sp.getInt(key, defaultValue)
    }

    // ********** Long **********//
    fun setLongInPref(key: String?, value: Long) {
        editor.putLong(key, value)
        editor.commit()
    }

    fun getLongInPref(key: String?): Long {
        return getLongInPref(key, -1)
    }

    fun getLongInPref(key: String?, defaultValue: Long): Long {
        return sp.getLong(key, defaultValue)
    }

    // ********** Float **********//
    fun setFloatInPref(key: String?, value: Float) {
        editor.putFloat(key, value)
        editor.commit()
    }

    fun getFloatInPref(key: String?): Float {
        return getFloatInPref(key, -1f)
    }

    fun getFloatInPref(key: String?, defaultValue: Float): Float {
        return sp.getFloat(key, defaultValue)
    }

    // ********** Boolean **********//
    fun setBooleanInPref(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getBooleanInPref(key: String?): Boolean {
        return sp.getBoolean(key, false)
    }

    // Shared Preferences end
    // storing user detail
    fun getUserDetails(): UserLoginDetail? {
        val params = sp.getString(AppConstant.HM_UserLoginDetail, null) ?: return null
        Logger.e(params)
        val mapType = object : TypeToken<UserLoginDetail?>() {}.type
        val gson = Gson()
        return gson.fromJson(params, mapType)
    }

    // getting user detail
    fun setUserDetails(params: UserLoginDetail?) {
        if (params == null) {
            return
        }
        val mapType = object : TypeToken<UserLoginDetail?>() {}.type
        val gson = Gson()
        val userMap = gson.toJson(params, mapType)
        editor.putString(AppConstant.HM_UserLoginDetail, userMap)
        editor.apply()
    }

}