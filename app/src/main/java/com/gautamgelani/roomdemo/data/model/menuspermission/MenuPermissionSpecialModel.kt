package com.gautamgelani.roomdemo.data.model.menuspermission

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuPermissionSpecialModel(
    @SerializedName("delete_permission")
    var delete_permission: Int = 0,

    @SerializedName("edit_permission")
    var edit_permission: Int = 0,

    @SerializedName("view_permission")
    var view_permission: Int = 0,

    @SerializedName("add_permission")
    var add_permission: Int = 0,

    @SerializedName("not_allow_permission")
    var not_allow_permission: Int = 0,

    @SerializedName("menu_id")
    var menu_id: Long = 0,

    @SerializedName("menu_title")
    var menu_title: String? = null,

    @SerializedName("menu_permission_profile_id")
    var menu_permission_profile_id: Long = 0,

    @SerializedName("menu_permission_id")
    var menu_permission_id: Long = 0,
) : Parcelable {

}
