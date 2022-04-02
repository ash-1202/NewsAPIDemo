package com.condenast.module.newsapi.model.response

import com.condenast.module.newsapi.model.Source

data class SourcesResponse(
    val status: String,
    val sources: List<Source>
)