package com.gautamgelani.roomdemo.utils

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

object DataTypeUtil {

    private lateinit var toast: Toast

    inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T
    ) = lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

    fun showToast(context: Context?, message: String?) { // change it like awk
        if (message == null || message.isEmpty() || context == null) return
        if (DataTypeUtil::toast.isInitialized) toast.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    fun showToast(context: Context?, resId: Int) { // change it like awk
        if (context == null) return
        if (DataTypeUtil::toast.isInitialized) toast.cancel()
        toast = Toast.makeText(context, resId, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    infix fun hideSoftKeyboard(mActivity: Activity) {
        // Check if no view has focus:
        val view = mActivity.currentFocus
        if (view != null) {
            val inputManager =
                mActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // get response status 0 true or 1 false
    infix fun isResponseSuccess(value: String): Boolean {
        return value == "0"
    }

}