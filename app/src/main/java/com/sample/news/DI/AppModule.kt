package com.sample.news.DI

import dagger.Module

@Module(includes = [(ViewModelModule::class)])
class AppModule{

    /* @Provides
     @Singleton
     fun provideApiInterface(retrofit: Retrofit): ApiInterface {
         return retrofit.create(ApiInterface::class.java)
     }*/


    /*@Binds
     internal abstract fun provideContext(application: Application): Context*/
    /* @Provides
     @Singleton
     internal abstract fun provideContext(application: Application): Context*//*

    @Binds
    internal fun providePostApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }*/

}