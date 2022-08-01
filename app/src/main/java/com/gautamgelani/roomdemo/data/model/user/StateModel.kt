package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StateModel(
    @SerializedName("state_id")
    var state_id: Long = 0,

    @SerializedName("state_name")
    val state_name: String = "",

    @SerializedName("country_id")
    val country_id: Long = 0L,

    @SerializedName("short_code")
    val short_code: String? = ""
) : Parcelable