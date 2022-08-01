package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompanyModel(
    @SerializedName("bookmark_colors")
    var bookmark_colors: List<BookmarkColorsModel>? = ArrayList(),

    @SerializedName("is_bookmark_color_config")
    var is_bookmark_color_config: Int = 0,

    @SerializedName("build_zoom_price")
    var build_zoom_price: Double = 0.0,

    @SerializedName("is_build_zoom_enable")
    var is_build_zoom_enable: Int = 0,

    @SerializedName("is_nxt_enable")
    var is_nxt_enable: Int = 0,

    @SerializedName("is_isn_enable")
    var is_isn_enable: Int = 0,

    @SerializedName("is_confirmation_required_inspection_date_time")
    var is_confirmation_required_inspection_date_time: Int = 0,

    @SerializedName("time_clock_task_list")
    var time_clock_task_list: String? = "",

    @SerializedName("associations_group_id")
    var associations_group_id: Long = 0,

    @SerializedName("lng")
    var lng: Double = 0.0,

    @SerializedName("lat")
    var lat1: Double = 0.0,

    @SerializedName("email_address")
    var email_address: String? = "",

    @SerializedName("logo_url")
    var logo_url: String? = "",

    @SerializedName("website")
    var website: String? = "",

    @SerializedName("main_phone_number")
    var main_phone_number: String? = "",

    @SerializedName("country_id")
    var country_id: Long = 0,

    @SerializedName("zip_code")
    var zip_code: String? = "",

    @SerializedName("state_id")
    var state_id: Long = 0,

    @SerializedName("city")
    var city: String? = "",

    @SerializedName("street_address")
    var street_address: String? = "",

    @SerializedName("company_name")
    var company_name: String? = "",

    @SerializedName("company_id")
    var company_id: Long = 0
) : Parcelable
