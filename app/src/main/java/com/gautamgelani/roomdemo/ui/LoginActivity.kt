package com.gautamgelani.roomdemo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gautamgelani.hiltmvvmdemo.utils.ValidationUtil
import com.gautamgelani.roomdemo.R
import com.gautamgelani.roomdemo.constant.AppConstant
import com.gautamgelani.roomdemo.data.model.user.UserLoginDetail
import com.gautamgelani.roomdemo.databinding.ActivityLoginBinding
import com.gautamgelani.roomdemo.network.NetworkStatus
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference.getUserDetails
import com.gautamgelani.roomdemo.sharedpreference.SharedPreference.setStringInPref
import com.gautamgelani.roomdemo.utils.BaseAppCompactActivity
import com.gautamgelani.roomdemo.utils.DataTypeUtil.isResponseSuccess
import com.gautamgelani.roomdemo.utils.DataTypeUtil.showToast
import com.gautamgelani.roomdemo.utils.DataTypeUtil.viewBinding
import com.gautamgelani.roomdemo.utils.MyApplication
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : BaseAppCompactActivity() {

    private val binding by viewBinding(ActivityLoginBinding::inflate)

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        FirebaseApp.initializeApp(MyApplication.context)
        getFCMToken()
        setUpObserver()
        binding.btnLogin.setOnClickListener {
            if (isValid()) {
                showProgressDialog()
                viewModel.doRequestForLogin(
                    binding.etUsername.text.toString().trim(),
                    binding.etPassword.text.toString().trim()
                )
            }
        }
    }

    private fun setUpObserver() {
        viewModel.getNetworkStates().observe(this) {
            when (it) {
                is NetworkStatus.Running -> {
                    showProgressDialog()
                }
                is NetworkStatus.Failed -> {
                    hideProgressDialog()
                }
                is NetworkStatus.NoInternet -> {
                    hideProgressDialog()
                }

                else -> hideProgressDialog()
            }
        }

        viewModel.userLoginDetail.observe(this) {
            it?.let { userLoginDetail ->
                if (isResponseSuccess(userLoginDetail.res)) {
                    storeDataInDB(userLoginDetail)
                } else {
                    hideProgressDialog()
                    showToast(this, userLoginDetail.msg)
                }
            } ?: run {
                hideProgressDialog()
                showToast(this, R.string.err_msg_login)
            }
        }
    }

    private fun storeDataInDB(userLoginDetail: UserLoginDetail) {
        lifecycleScope.launch{
            viewModel.storeDataInDB(userLoginDetail)
            SharedPreference.setUserDetails(userLoginDetail)
            hideProgressDialog()
            val userLoginDetail = getUserDetails()

        }
    }

    private fun isValid(): Boolean {
        if (ValidationUtil.validateEmptyEditText(binding.etUsername)) {
            showToast(this@LoginActivity, getString(R.string.err_msg_enter_user_name))
            ValidationUtil.requestFocus(this@LoginActivity, binding.etUsername)
            return false
        }
        if (ValidationUtil.validateEmptyEditText(binding.etPassword)) {
            showToast(this@LoginActivity, getString(R.string.err_msg_enter_password))
            ValidationUtil.requestFocus(this@LoginActivity, binding.etPassword)
            return false
        }
        return true
    }

    private fun getFCMToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                Logger.e("Fetching FCM registration token failed")
            } else if (it.result != null) {
                // Get new FCM registration token
                val token: String? = it.result
                setStringInPref(AppConstant.HI_FCM_Token, token)
                token?.let { it1 -> Logger.e(it1) }
            }
        }
    }
}