package com.sample.news.service_retrofit.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sample.news.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsObject(
    @SerializedName("source") val source: Source?, @SerializedName("author") val author: String?, @SerializedName(
        "title"
    )@Bindable val title: String?, @SerializedName("description")@Bindable val description: String?, @SerializedName("url") val url: String?, @SerializedName(
        "urlToImage"
    ) @Bindable val urlToImage: String?, @SerializedName("publishedAt") val publishedAt: String?, @SerializedName("content") val content: String?
) : Parcelable,
    BaseObservable() {
    val getTitle: String?
        get() {
            notifyPropertyChanged(BR.title)
            return title
        }

    val getDescription: String?
        get() {
            notifyPropertyChanged(BR.description)
            return description
        }

    val getUrlToImage: String?
        get() {
            notifyPropertyChanged(BR.urlToImage)
            return urlToImage
        }
}

@Parcelize
data class Source(@SerializedName("id") val id: String?, @SerializedName("name") val name: String?) : Parcelable

data class result(
    @SerializedName("status") val status: String, @SerializedName("totalResults") val totalCount: Int, @SerializedName(
        "articles"
    ) val articles: List<NewsObject>
)