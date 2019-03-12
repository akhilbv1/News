package com.sample.news.service_retrofit.repositories

import retrofit2.Response
import com.sample.news.service_retrofit.model.result
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor (val newsApi: NewsApi) {

    fun getNewsList(): Single<Response<result>>{
        return newsApi.getNewsList()
    }

}