package com.gautamgelani.hiltmvvmdemo.utils

import android.app.Activity
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Matcher
import java.util.regex.Pattern

object ValidationUtil {
    infix fun validateEmptyEditText(et_advertise: AppCompatEditText): Boolean {
        return et_advertise.text.toString().trim { it <= ' ' }.isEmpty()
    }

    infix fun validateEmail(et_email: AppCompatEditText): Boolean {
        val email = et_email.text.toString().trim { it <= ' ' }
        return email.isEmpty() || !isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidWebUrl(url: String): Boolean {
        return !TextUtils.isEmpty(url) && !Patterns.WEB_URL.matcher(url).matches()
    }

    fun validatePassword(et_password: AppCompatEditText): Boolean {
        val password = et_password.text.toString().trim { it <= ' ' }
        return password.isEmpty() || !isValidPassword(password)
    }

    fun validateConfirmPassword(
        et_password: AppCompatEditText,
        et_confirm_password: AppCompatEditText
    ): Boolean {
        return et_password.text.toString().trim { it <= ' ' } != et_confirm_password.text.toString()
            .trim { it <= ' ' }
    }

    private fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun validateMobileNo(et_mobile_no: AppCompatEditText): Boolean {
        val mobile_no = et_mobile_no.text.toString().trim { it <= ' ' }
        return mobile_no.isEmpty() || !isValidMobileNo(mobile_no)
    }

    private fun isValidMobileNo(mobile_no: String): Boolean {
        return !TextUtils.isEmpty(mobile_no) && (mobile_no.length in 7..15)
    }

    fun requestFocus(context: Activity, view: View) {
        if (view.requestFocus()) {
            context.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    fun validateZip(et_zip: AppCompatEditText): Boolean {
        val zip = et_zip.text.toString().trim { it <= ' ' }
        return zip.isEmpty() || !isValidZip(zip)
    }

    private fun isValidZip(zip: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val ZIP_PATTERN = "^(?!.*[DFIOQUdfioqu])[A-VXYa-vxy][0-9][A-Za-z] ?[0-9][A-Za-z][0-9]$"
        pattern = Pattern.compile(ZIP_PATTERN)
        matcher = pattern.matcher(zip)
        return matcher.matches()
    }

    fun validateLength(et_zip: AppCompatEditText, length: Int): Boolean {
        val zip = et_zip.text.toString().trim { it <= ' ' }
        return zip.isEmpty() || !isValidLength(et_zip.text.toString(), length)
    }

    fun isValidLength(et_zip: String, length: Int): Boolean {
        return et_zip.length == length
    }

    fun validateRange(
        editText: AppCompatEditText,
        lessThenValue: Double,
        greaterThenValue: Double
    ): Boolean {
        val value = editText.text.toString().trim { it <= ' ' }
        return value.isEmpty() || isValidRange(
            editText.text.toString(),
            lessThenValue,
            greaterThenValue
        )
    }

    fun isValidRange(editText: String, lessThenValue: Double, greaterThenValue: Double): Boolean {
        return editText == "." || editText.toDouble() < lessThenValue || editText.toDouble() > greaterThenValue
    }
}