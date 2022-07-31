package com.gautamgelani.roomdemo.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServerResponseModel<T>(
    @SerializedName("res") val res: String,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: T?,
) : Serializable