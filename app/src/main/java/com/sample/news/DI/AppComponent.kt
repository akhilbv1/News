package com.sample.news.DI

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import com.sample.news.NewsApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class),  (ActivitiesBindingModule::class), (NetworkModule::class)])
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(app: NewsApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(app: Application):Builder

        fun build(): AppComponent
    }
}