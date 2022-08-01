package com.gautamgelani.roomdemo.data.model.menuspermission

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuPermissionModel(
    @SerializedName("menus")
    var menus: ArrayList<MenusDetail?>? = null,

    @SerializedName("menu_title")
    var menu_title: String? = null,

    @SerializedName("edit_permission")
    var edit_permission: Int = 0,

    @SerializedName("delete_permission")
    var delete_permission: Int = 0,

    @SerializedName("view_permission")
    var view_permission: Int = 0,

    @SerializedName("menu_id")
    var menu_id: Long = 0,
) : Parcelable {

}
