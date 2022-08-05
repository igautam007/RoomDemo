package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.gautamgelani.roomdemo.data.db.entity.Country
import com.gautamgelani.roomdemo.data.db.entity.Option
import com.gautamgelani.roomdemo.data.db.entity.Options_Category
import com.gautamgelani.roomdemo.data.db.entity.State
import com.gautamgelani.roomdemo.data.model.menuspermission.MenuPermissionModel
import com.gautamgelani.roomdemo.data.model.menuspermission.MenuPermissionSpecialModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserLoginDetail(
    @SerializedName("res") var res: String = "",
    @SerializedName("msg") var msg: String? = null,
    @SerializedName("data") var data: Data? = null,
    @SerializedName("token") var token: String? = null
) : Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("MenuPermissionSpecialModel")
        var menuPermissionSpecialModelList: List<MenuPermissionSpecialModel>? = ArrayList(),

        @SerializedName("menu_permission")
        var menu_permission: List<MenuPermissionModel>? = ArrayList(),

        @SerializedName("employee")
        var employee: EmployeeModel? = null,

        @SerializedName("company")
        var company: CompanyModel? = null,

        @SerializedName("user")
        var user: UserModel? = null,

        @SerializedName("country")
        var country: List<Country>? = null,

        @SerializedName("state")
        var state: List<State>? = null,

        @SerializedName("option_categories")
        var option_categories: List<Options_Category>? = null,

        @SerializedName("option")
        var option: List<Option>? = null,


        ) : Parcelable
}
