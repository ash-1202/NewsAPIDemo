package com.condenast.newsapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.condenast.newsapi.fragment.TopHeadlinesFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addHeadlinesFragment()
    }

    fun addHeadlinesFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<TopHeadlinesFragment>(R.id.fragmentContainer)
        }
    }

}