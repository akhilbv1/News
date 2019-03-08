package com.sample.news.Service.Repositories

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import com.sample.news.Service.Model.NewsObject

interface NewsApi{

    @GET("top-headlines?sources=bbc-news&apiKey=ff8f4e71f28e4896ab3e44b270384bb4")
    fun getNewsList():Single<Response<List<NewsObject>>>
}