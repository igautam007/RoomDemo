package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookmarkColorsModel(
    @SerializedName("is_deleted")
    var is_deleted: Int = 0,

    @SerializedName("last_updated_date")
    var last_updated_date: String? = "",

    @SerializedName("last_updated_by")
    var last_updated_by: Long = 0,

    @SerializedName("created_date")
    var created_date: String? = "",

    @SerializedName("created_by")
    var created_by: Long = 0,

    @SerializedName("color_code")
    var color_code: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("company_id")
    var company_id: Long = 0,

    @SerializedName("bookmark_color_id")
    var bookmark_color_id: Int = 0
) : Parcelable
