package com.gautamgelani.roomdemo.ui

import android.os.Bundle
import com.gautamgelani.roomdemo.R
import com.gautamgelani.roomdemo.utils.BaseAppCompactActivity

class LoginActivity : BaseAppCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        showProgressDialog()

    }
}