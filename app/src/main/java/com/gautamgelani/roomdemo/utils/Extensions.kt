package com.gautamgelani.roomdemo.utils

import android.view.View

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.showProgressbar() {
    this.visibility = View.VISIBLE
    // AppConstant.GR_IsProgressBarRunning = true
}

fun View.hideProgressbar() {
    this.visibility = View.GONE
    //   AppConstant.GR_IsProgressBarRunning = true
}