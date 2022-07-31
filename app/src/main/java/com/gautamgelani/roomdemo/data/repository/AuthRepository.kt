package com.gautamgelani.roomdemo.data.repository

import android.content.Context
import com.gautamgelani.roomdemo.network.ApiInterface
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    @ApplicationContext context: Context,
    private val apiInterface: ApiInterface
) : BaseRepository(context) {

    /*suspend fun doRequestForLogin(params: JsonObject): UserLoginDetail? {
        val call = apiInterface.doRequestForLogin(params)

        return runApiWithCustomResponse({
            call
        }, APIConstant.HM_PermitUserLoginUrl)
    }*/

}