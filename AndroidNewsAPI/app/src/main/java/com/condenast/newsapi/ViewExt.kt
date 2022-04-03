package com.condenast.newsapi

import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.condenast.newsapi.Constant.appInstance

object ViewExt {

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun showToast(msg: String) {
        Toast.makeText(appInstance, "Please enter Api Key", Toast.LENGTH_SHORT).show()
    }
}