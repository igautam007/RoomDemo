package com.gautamgelani.roomdemo.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gautamgelani.roomdemo.constant.AppConstant
import com.gautamgelani.roomdemo.data.model.user.UserLoginDetail
import com.gautamgelani.roomdemo.data.repository.AuthRepository
import com.gautamgelani.roomdemo.network.NetworkViewModel
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference
import com.gautamgelani.roomdemo.utils.HttpRequestHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext context: Context,
    override val repository: AuthRepository
) : NetworkViewModel(context) {

    val userLoginDetail = MutableLiveData<UserLoginDetail?>()

    fun doRequestForLogin(username: String, password: String) {
        val params = HttpRequestHandler.getLoginUserJson(
            username,
            password,
            SharedPreference.getStringFromPref(AppConstant.HI_FCM_Token)
        )

        viewModelScope.launch {
            val result = repository.doRequestForLogin(params)
            userLoginDetail.value = result
        }
    }

    suspend fun storeDataInDB(userLoginDetail: UserLoginDetail) {
        repository.storeDataInDB(userLoginDetail)
    }
}