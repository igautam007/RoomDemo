package com.gautamgelani.hiltmvvmdemo.data.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserLoginDetail(
    @SerializedName("res") var res: String? = null,
    @SerializedName("msg") var msg: String? = null,
    @SerializedName("data") var data: Data? = null,
    @SerializedName("token") var token: String? = null
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("user_id") var user_id: Long = 0,
        @SerializedName("first_name") var first_name: String? = null,
        @SerializedName("last_name") var last_name: String? = null,
        @SerializedName("password") var password: String? = null,
        @SerializedName("email_address") var email_address: String? = null,
        @SerializedName("phone_number") var phone_number: String? = null,
        @SerializedName("uuid") var uuid: String? = null,
        @SerializedName("created_date") var created_date: String? = null,
        @SerializedName("last_updated_date") var last_updated_date: String? = null,
        @SerializedName("is_deleted") var is_deleted: String? = null
    ) : Parcelable
}
