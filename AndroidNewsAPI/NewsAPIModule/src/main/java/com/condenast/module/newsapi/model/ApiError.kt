package com.condenast.module.newsapi.model

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)