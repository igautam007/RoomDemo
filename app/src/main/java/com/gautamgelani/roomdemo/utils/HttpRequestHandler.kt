package com.gautamgelani.roomdemo.utils

import com.gautamgelani.roomdemo.constant.KeyConstant
import com.google.gson.JsonObject
import org.json.JSONException

object HttpRequestHandler {

    // login request params
    fun getLoginUserJson(
        etUsername: String?,
        etPassword: String?,
        deviceToken: String?
    ): JsonObject {
        val params = JsonObject()
        try {
            params.addProperty(KeyConstant.HI_Username, etUsername)
            params.addProperty(KeyConstant.HI_Password, etPassword)
            params.addProperty(KeyConstant.HI_DeviceType, "A")
            params.addProperty(KeyConstant.HI_DeviceToken, deviceToken)
            params.addProperty(KeyConstant.HI_AppVersion, "2.0.37")
            params.addProperty(KeyConstant.HI_IpAddress, "")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return params
    }

}