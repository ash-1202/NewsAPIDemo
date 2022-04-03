package com.condenast.newsapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.condenast.module.newsapi.NewsApi
import com.condenast.newsapi.Constant.API_BUNDLE_KEY
import com.condenast.newsapi.fragment.SplashLoginFragment
import com.condenast.newsapi.fragment.TopHeadlinesFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addSplashLoginFragment()

        supportFragmentManager
            .setFragmentResultListener(Constant.API_REQUEST_KEY, this) { requestKey, bundle ->
                // We use a String here, but any type that can be put in a Bundle is supported
                val result = bundle.getString(API_BUNDLE_KEY)
                // Do something with the result
                NewsApi.initialize(result!!)
                addHeadlinesFragment()
            }
    }

    private fun addSplashLoginFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<SplashLoginFragment>(R.id.fragmentContainer)
        }
    }

    private fun addHeadlinesFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<TopHeadlinesFragment>(R.id.fragmentContainer)
        }
    }

}