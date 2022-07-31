package com.gautamgelani.roomdemo.utils

import com.gautamgelani.roomdemo.constant.KeyConstant
import com.google.gson.JsonObject

object HttpRequestHandler {

    fun getUserLoginJson(email: String, password: String): JsonObject {
        val params = JsonObject()
        params.addProperty(KeyConstant.HM_EmailAddress, email)
        params.addProperty(KeyConstant.HM_Password, password)
        params.addProperty(KeyConstant.HM_DeviceType, "A")
        params.addProperty(KeyConstant.HM_DeviceToken, "")
        params.addProperty(KeyConstant.HM_AppVersion, "1")
        params.addProperty(KeyConstant.HM_IpAddress, "")
        return params
    }

}