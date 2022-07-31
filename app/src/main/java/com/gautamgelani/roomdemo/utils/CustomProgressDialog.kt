package com.gautamgelani.roomdemo.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.gautamgelani.roomdemo.R


class CustomProgressDialog(context: Context) {

    private var dialog: CustomDialog
    private var cpTitle: AppCompatTextView
    private var cpCardView: CardView
    private var progressBar: ProgressBar

    fun start(title: String = "") {
        cpTitle.text = title
        dialog.show()
    }

    fun stop() {
        dialog.dismiss()
    }

    init {
        val inflater = (context as Activity).layoutInflater
        val view = inflater.inflate(R.layout.custom_progressbar, null)

        cpTitle = view.findViewById(R.id.cp_title)
        cpCardView = view.findViewById(R.id.cp_cardview)
        progressBar = view.findViewById(R.id.cp_pbar)

        // Card Color
        cpCardView.setCardBackgroundColor(
            ContextCompat.getColor(
                context,
                android.R.color.transparent
            )
        )

        // Progress Bar Color
        setColorFilter(
            progressBar.indeterminateDrawable,
            ContextCompat.getColor(context, R.color.purple_500)
        )

        // Text Color
        cpTitle.setTextColor(Color.WHITE)

        // Custom Dialog initialization
        dialog = CustomDialog(context)
        dialog.setCancelable(false)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dialog.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.background_progressbar
            )
        );
        dialog.setContentView(view)
    }

    private fun setColorFilter(drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }

    class CustomDialog(context: Context) : Dialog(context, R.style.CustomDialogTheme) {
        init {
            // Set Semi-Transparent Color for Dialog Background
            window?.decorView?.rootView?.setBackgroundResource(R.color.white)
            window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                insets.consumeSystemWindowInsets()
            }
        }
    }
}