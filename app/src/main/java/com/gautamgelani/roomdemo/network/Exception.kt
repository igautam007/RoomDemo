package com.gautamgelani.roomdemo.network

import java.io.IOException

class NoInternetException(
    message: String = "No network available, please check your WiFi or Internet connection"
) : Exception(message) {
}

class CallFailedApiException(message: String) : IOException(message)
