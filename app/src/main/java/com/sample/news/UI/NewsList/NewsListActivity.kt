package com.sample.news.UI.NewsList

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import com.sample.news.UI.ViewModels.NewsListViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewsListActivity:DaggerAppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var newsListViewModel:NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}