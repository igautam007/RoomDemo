package com.gautamgelani.roomdemo.utils

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class BaseAppCompactActivity : AppCompatActivity() {

    protected lateinit var app: MyApplication

    lateinit var dialogProgress: CustomProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = MyApplication.context
        dialogProgress = CustomProgressDialog(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Show progress dialog
    fun showProgressDialog() {
        dialogProgress.start("Please wait...")
    }

    // Hide progress dialog
    fun hideProgressDialog() {
        dialogProgress.stop()
    }
}