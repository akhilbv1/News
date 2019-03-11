package com.sample.news.Service.Repositories

import android.arch.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import com.sample.news.Service.Model.NewsObject
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor (val newsApi: NewsApi) {

    fun getNewsList(): Single<Response<List<NewsObject>>> {
        return newsApi.getNewsList()
    }

}