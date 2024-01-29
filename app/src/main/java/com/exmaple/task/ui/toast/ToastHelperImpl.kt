package com.exmaple.task.ui.toast

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class ToastHelperImpl(private val context: Context) : ToastHelper {
    override fun showToast(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}