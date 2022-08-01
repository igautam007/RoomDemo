package com.gautamgelani.roomdemo.ui

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.gautamgelani.roomdemo.constant.AppConstant
import com.gautamgelani.roomdemo.data.repository.AuthRepository
import com.gautamgelani.roomdemo.network.NetworkViewModel
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference
import com.gautamgelani.roomdemo.utils.HttpRequestHandler
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext context: Context,
    override val repository: AuthRepository
) : NetworkViewModel(context) {

    fun doRequestForLogin(username: String, password: String) {
        val params = HttpRequestHandler.getLoginUserJson(
            username,
            password,
            SharedPreference.getStringFromPref(AppConstant.HI_FCM_Token)
        )

        viewModelScope.launch {
            val result = repository.doRequestForLogin(params)
            Logger.e(result.toString())
        }
    }
}