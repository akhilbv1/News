package com.sample.news.UI.ViewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sample.news.Service.Model.NewsObject
import com.sample.news.Service.Model.Source


class NewsListBindingViewModel : ViewModel() {

    val description = MutableLiveData<String>()
    val url = MutableLiveData<String>()
    val urlToImage = MutableLiveData<String>()
    val publishedAt = MutableLiveData<String>()
    val content = MutableLiveData<String>()


    val author = MutableLiveData<String>()

    val title = MutableLiveData<String>()

    val source = MutableLiveData<Source>()

    val id = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    fun bind(newObj: NewsObject) {
        description.value = newObj.description
        url.value = newObj.url
        urlToImage.value = newObj.urlToImage
        content.value = newObj.content
        publishedAt.value = newObj.publishedAt
        title.value = newObj.title
        author.value = newObj.author
        id.value = newObj.source?.id
        name.value = newObj.source?.name
    }



}