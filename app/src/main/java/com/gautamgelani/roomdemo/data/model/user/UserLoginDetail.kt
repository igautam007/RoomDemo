package com.gautamgelani.roomdemo.data.model.user

import android.os.Parcelable
import com.gautamgelani.roomdemo.data.model.menuspermission.MenuPermissionModel
import com.gautamgelani.roomdemo.data.model.menuspermission.MenuPermissionSpecialModel
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

        /*@SerializedName("role")
        var role: Role? = null,*/

        @SerializedName("country")
        var country: List<CountryModel>? = null,

        @SerializedName("state")
        var state: List<StateModel>? = null,

        @SerializedName("option_categories")
        var option_categories: List<OptionsCategoryModel>? = null,

        @SerializedName("option")
        var option: List<OptionsModel>? = null,

        @SerializedName("appliance")
        var appliance: List<ApplianceModel>? = null

    ) : Parcelable

    /*@Parcelize
    data class Role(
        @SerializedName("role_id")
        var role_id: Long = 0,

        @SerializedName("role_name")
        var role_name: String? = ""
    ) : Parcelable*/
}
