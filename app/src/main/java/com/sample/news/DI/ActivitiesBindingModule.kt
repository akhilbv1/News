package com.sample.news.DI

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.sample.news.UI.NewsList.NewsListActivity

@Module
abstract class ActivitiesBindingModule{

    @ContributesAndroidInjector
    abstract fun newsListActivity():NewsListActivity

}