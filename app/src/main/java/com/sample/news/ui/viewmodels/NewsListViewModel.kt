package com.sample.news.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sample.news.service_retrofit.model.NewsObject
import com.sample.news.service_retrofit.model.result
import com.sample.news.service_retrofit.repositories.Repository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class NewsListViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val onGetNewsListSuccess: MutableLiveData<List<NewsObject>> = MutableLiveData()

    private val onGetNewsListError: MutableLiveData<Throwable> = MutableLiveData()


    fun getNewsList() {
        repository.getNewsList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<result>> {
                override fun onSuccess(t: Response<result>) {
                    onGetNewsListSuccess.value = t.body()?.articles
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    onGetNewsListError.value = e

                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getSuccessLiveData(): MutableLiveData<List<NewsObject>> = onGetNewsListSuccess

    fun getErrorLiveData(): MutableLiveData<Throwable> = onGetNewsListError


}
