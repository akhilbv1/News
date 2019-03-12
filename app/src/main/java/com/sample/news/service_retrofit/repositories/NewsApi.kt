package com.sample.news.service_retrofit.repositories

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import com.sample.news.service_retrofit.model.result

interface NewsApi{

    @GET("top-headlines?sources=bbc-news&apiKey=ff8f4e71f28e4896ab3e44b270384bb4")
    fun getNewsList():Single<Response<result>>
}