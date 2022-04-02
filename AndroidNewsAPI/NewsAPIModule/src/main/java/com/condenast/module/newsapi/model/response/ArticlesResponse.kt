package com.condenast.module.newsapi.model.response

import com.condenast.module.newsapi.model.Article

data class ArticlesResponse(
    val status: String,
    val totalResults: String,
    val articles: List<Article>
)