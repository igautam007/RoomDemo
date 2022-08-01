package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryModel(
    @SerializedName("country_id")
    var country_id: Long = 0,
    @SerializedName("country_name")
    val country_name: String? = ""
) : Parcelable