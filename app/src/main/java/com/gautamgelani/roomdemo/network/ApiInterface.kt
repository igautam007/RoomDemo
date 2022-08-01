package com.gautamgelani.roomdemo.network

import com.gautamgelani.roomdemo.constant.APIConstant
import com.gautamgelani.roomdemo.data.model.user.UserLoginDetail
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers("Content-Type:application/json")
    @POST(APIConstant.HI_LoginUrl)
    suspend fun doRequestForLogin(
        @Body postData: JsonObject
    ): Response<UserLoginDetail>

}