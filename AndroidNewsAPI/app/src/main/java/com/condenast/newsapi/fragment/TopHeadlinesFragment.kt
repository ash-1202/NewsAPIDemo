package com.condenast.newsapi.fragment

import com.condenast.newsapi.adapter.ArticlesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.condenast.module.newsapi.NewsApi
import com.condenast.module.newsapi.listener.OnArticlesListener
import com.condenast.module.newsapi.model.ApiError
import com.condenast.module.newsapi.model.response.ArticlesResponse
import com.condenast.newsapi.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_top_headlines.*

class TopHeadlinesFragment : Fragment(), OnArticlesListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_headlines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsApi.getTopHeadlines(onArticlesListener = this, searchTerm = "US")
    }

    override fun onArticlesResponse(articlesResponse: ArticlesResponse) {
        val adapter = ArticlesAdapter(articlesResponse.articles, requireContext())
        topHeadlinesRecyclerView.setHasFixedSize(true)
        topHeadlinesRecyclerView.layoutManager = LinearLayoutManager(context)
        topHeadlinesRecyclerView.adapter = adapter
    }

    override fun onError(apiError: ApiError?) {
        Snackbar.make(topHeadlinesRootView, apiError?.message.toString(), Snackbar.LENGTH_SHORT)
            .show()
    }
}
