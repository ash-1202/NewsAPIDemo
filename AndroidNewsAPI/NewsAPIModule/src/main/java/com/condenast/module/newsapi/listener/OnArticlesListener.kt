package com.condenast.module.newsapi.listener

import com.condenast.module.newsapi.model.ApiError
import com.condenast.module.newsapi.model.response.ArticlesResponse

interface OnArticlesListener {
    fun onArticlesResponse(articlesResponse: ArticlesResponse)
    fun onError(apiError: ApiError?)
}