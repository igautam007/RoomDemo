package com.gautamgelani.roomdemo.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object NetworkUtils {

    //check if user is online or not
    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        var isConnected = false
        if (connectivityManager is ConnectivityManager) {
            isConnected = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                val networkInfo = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            } else {
                val networkCapabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

                networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false || networkCapabilities?.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI
                ) ?: false

            }
        }
        return isConnected
    }

}