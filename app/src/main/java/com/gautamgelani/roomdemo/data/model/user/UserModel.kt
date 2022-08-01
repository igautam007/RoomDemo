package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("user_configuration")
    var user_configuration: User_configuration? = null,

    @SerializedName("profile_logo")
    var profile_logo: String? = "",

    @SerializedName("login_type")
    var login_type: String? = "",

    @SerializedName("social_id")
    var social_id: String? = "",

    @SerializedName("office_phone")
    var office_phone: String? = "",

    @SerializedName("mobile_phone")
    var mobile_phone: String? = "",

    @SerializedName("company_id")
    var company_id: Long = 0,

    @SerializedName("email_address")
    var email_address: String? = "",

    @SerializedName("password")
    var password: String? = "",

    @SerializedName("username")
    var username: String? = "",

    @SerializedName("last_name")
    var last_name: String? = "",

    @SerializedName("menu_permission_profile_id")
    var menu_permission_profile_id: Long = 0,

    @SerializedName("first_name")
    var first_name: String? = null,

    @SerializedName("role_id")
    var role_id: Long = 0,

    @SerializedName("user_id")
    var user_id: Long = 0
) : Parcelable {

    @Parcelize
    data class User_configuration(
        @SerializedName("ie_font_type")
        var ie_font_type: String? = "",

        @SerializedName("ie_shape_color")
        var ie_shape_color: String? = "",

        @SerializedName("ie_shape_width")
        var ie_shape_width: String? = "",
    ) : Parcelable
}