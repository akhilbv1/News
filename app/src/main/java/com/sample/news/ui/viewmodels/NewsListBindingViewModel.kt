package com.sample.news.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sample.news.service_retrofit.model.NewsObject
import com.sample.news.service_retrofit.model.Source


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
/*
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String?) {
            val context = view.context
            Glide.with(context).load(url).listener(object :RequestListener<String?,GlideDrawable?>{
                override fun onResourceReady(
                    resource: GlideDrawable?,
                    model: String?,
                    target: Target<GlideDrawable?>?,
                    isFromMemoryCache: Boolean,
                    isFirstResource: Boolean
                ): Boolean {
                  return true
                }

                override fun onException(
                    e: Exception?,
                    model: String?,
                    target: Target<GlideDrawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    e?.printStackTrace()

                   return true
                 }

            }).into(view)
        }
    }*/

}