package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OptionsCategoryModel(

    @SerializedName("option_category_id")
    var option_category_id: Long = 0,
    @SerializedName("title")
    val title: String? = null,
) : Parcelable
