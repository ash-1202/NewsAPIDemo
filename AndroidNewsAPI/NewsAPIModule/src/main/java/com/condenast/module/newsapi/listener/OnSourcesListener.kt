package com.condenast.module.newsapi.listener

import com.condenast.module.newsapi.model.ApiError
import com.condenast.module.newsapi.model.response.SourcesResponse

interface OnSourcesListener {
    fun onSourcesResponse(sourcesResponse: SourcesResponse)
    fun onError(apiError: ApiError?)
}