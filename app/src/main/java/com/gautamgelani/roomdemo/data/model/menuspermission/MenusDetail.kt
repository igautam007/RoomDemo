package com.gautamgelani.roomdemo.data.model.menuspermission

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenusDetail(
    /*@SerializedName("menu_permission_special")
    var menu_permission_special: SubMenu_Permissions? = null,*/
    @SerializedName("menu_title")
    var menu_title: String? = null

) : Parcelable {

}
