package com.sample.news.DI

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.sample.news.UI.ViewModels.NewsListViewModel
import com.sample.news.Utils.ViewModelFactory
import com.sample.news.Utils.ViewModelKey

@Module
abstract class ViewModelModule{

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    internal abstract fun usersListViewModel(listViewModel: NewsListViewModel): ViewModel

}