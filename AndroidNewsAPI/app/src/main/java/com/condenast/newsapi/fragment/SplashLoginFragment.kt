package com.condenast.newsapi.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.condenast.newsapi.Constant.API_BUNDLE_KEY
import com.condenast.newsapi.Constant.API_KEY
import com.condenast.newsapi.Constant.API_REQUEST_KEY
import com.condenast.newsapi.R
import com.condenast.newsapi.ViewExt.gone
import com.condenast.newsapi.ViewExt.showToast
import com.condenast.newsapi.ViewExt.visible
import kotlinx.android.synthetic.main.fragment_splash_login.*
import kotlinx.android.synthetic.main.layout_login.*

class SplashLoginFragment: Fragment(), View.OnClickListener {

    private val SPLASH_DELAY = 2000L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            layout_splash.gone()
            layout_login.visible()
            button_submit.setOnClickListener(this)
        }, SPLASH_DELAY)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.button_submit -> {

                val apiKey = tvLogin.text.toString()
                if (apiKey!!.isNotEmpty()) {
                    // Use the Kotlin extension in the fragment-ktx artifact
                    setFragmentResult(API_REQUEST_KEY, bundleOf(API_BUNDLE_KEY to apiKey))
                } else {
                    showToast(resources.getString(R.string.no_api_key_error))
                }
            }
        }
    }


}