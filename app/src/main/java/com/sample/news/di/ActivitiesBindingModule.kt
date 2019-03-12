package com.sample.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.sample.news.ui.newslist.NewsListActivity

@Module
abstract class ActivitiesBindingModule{

    @ContributesAndroidInjector
    abstract fun newsListActivity():NewsListActivity

}