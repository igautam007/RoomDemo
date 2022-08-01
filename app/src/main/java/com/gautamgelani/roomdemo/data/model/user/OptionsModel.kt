package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OptionsModel(
    @SerializedName("option_id")
    var option_id: Long = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("option_category_id")
    val option_category_id: Long = 0L,
    @SerializedName("is_required_account")
    val is_required_account: Int = 0,
    @SerializedName("icon_url")
    val icon_url: String? = "",
) : Parcelable