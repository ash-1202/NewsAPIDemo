package com.condenast.newsapi

import android.app.Application
import com.condenast.module.newsapi.NewsApi
import com.condenast.newsapi.Constant.API_KEY
import com.condenast.newsapi.Constant.appInstance

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}