package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeModel(
    @SerializedName("country_id")
    var country_id: Long = 0,

    @SerializedName("logo_url")
    var logo_url: String? = "",

    @SerializedName("created_datetime")
    var created_datetime: String? = "",

    @SerializedName("lng")
    var lng: Double = 0.0,

    @SerializedName("lat")
    var lat: Double = 0.0,

    @SerializedName("is_deleted")
    var is_deleted: Int = 0,

    @SerializedName("sort_order")
    var sort_order: Int = 0,

    @SerializedName("zip_code")
    var zip_code: String? = "",

    @SerializedName("state_id")
    var state_id: Long = 0,

    @SerializedName("city")
    var city: String? = "",

    @SerializedName("home_address")
    var home_address: String? = "",

    @SerializedName("office_email")
    var office_email: String? = "",

    @SerializedName("personal_email")
    var personal_email: String? = "",

    @SerializedName("office_number")
    var office_number: String? = "",

    @SerializedName("mobile")
    var mobile: String? = "",

    @SerializedName("colour_code")
    var colour_code: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("last_name")
    var last_name: String? = "",

    @SerializedName("first_name")
    var first_name: String? = "",

    @SerializedName("user_id")
    var user_id: Long = 0,

    @SerializedName("employee_id")
    var employee_id: Long = 0,

    @SerializedName("user_role_id")
    var user_role_id: Int = 0,
) : Parcelable {

    override fun toString(): String {
        var name = ""
        if (first_name != null && !first_name!!.isEmpty()) name = first_name!!.trim { it <= ' ' }
        if (last_name != null && !last_name!!.isEmpty()) name =
            (if (!name.isEmpty()) "$name " else "") + last_name!!.trim { it <= ' ' }
        return name
    }
}