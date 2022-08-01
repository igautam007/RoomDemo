package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApplianceModel(
    @SerializedName("appliance_id")
    var appliance_id: Long = 0L,

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("appliance_image_url")
    val appliance_image_url: String = "",

    @SerializedName("create_date")
    val create_date: String? = "",

    @SerializedName("created_by")
    val created_by: Long = 0L,

    @SerializedName("last_update_date")
    val last_update_date: String? = "",

    @SerializedName("last_updated_by")
    val last_updated_by: Long = 0L,

    @SerializedName("is_deleted")
    val is_deleted: Int = 0
) : Parcelable