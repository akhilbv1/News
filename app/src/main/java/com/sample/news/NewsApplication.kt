package com.sample.news

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.sample.news.DI.DaggerAppComponent

class NewsApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out dagger.android.DaggerApplication> {

        return DaggerAppComponent.builder().create(this).build()
    }


}