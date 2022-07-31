package com.gautamgelani.roomdemo.network

sealed class NetworkStatus {

    data class Running(val msg: String = "", val apiName: String = "") : NetworkStatus()

    data class Success(val msg: String = "", val apiName: String = "") : NetworkStatus()

    //If Internet connection is not available.
    data class NoInternet(
        val msg: String = "Please check your internet connection.",
        val apiName: String = ""
    ) : NetworkStatus()

    //Call failed or any exception occur
    data class Failed(
        val msg: String = "Something went wrong please try again later.",
        val id: Int? = 0,
        val apiName: String = ""
    ) : NetworkStatus()

    //Auth token expired
    data class AuthToken(
        val msg: String = "Authentication token expired.",
        val apiName: String = ""
    ) : NetworkStatus()
}
