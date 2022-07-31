package com.gautamgelani.roomdemo.utils

import android.content.Context
import android.os.StrictMode
import androidx.lifecycle.MutableLiveData
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.gautamgelani.hiltmvvmdemo.data.model.user.UserLoginDetail
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : MultiDexApplication() {

    companion object {
        lateinit var context: MyApplication
        var userLoginDetail = MutableLiveData<UserLoginDetail>()
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        userLoginDetail.value = SharedPreference.getUserDetails()
        Logger.addLogAdapter(AndroidLogAdapter())
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}