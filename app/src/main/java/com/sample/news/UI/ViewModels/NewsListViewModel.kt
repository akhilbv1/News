package com.sample.news.UI.ViewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sample.news.Service.Model.NewsObject
import com.sample.news.Service.Repositories.Repository
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
            .subscribe(object : SingleObserver<Response<List<NewsObject>>> {
                override fun onSuccess(t: Response<List<NewsObject>>) {
                    onGetNewsListSuccess.value = t.body()
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    onGetNewsListError.value = e

                }

            })
    }

    fun getCompositeDisposable():CompositeDisposable = compositeDisposable

    fun getSuccessLiveData(): MutableLiveData<List<NewsObject>> = onGetNewsListSuccess

    fun getErrorLiveData(): MutableLiveData<Throwable> = onGetNewsListError


}
