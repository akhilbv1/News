package com.sample.news.ui.newslist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sample.news.R
import com.sample.news.databinding.NewsListRowItemBinding
import com.sample.news.service_retrofit.model.NewsObject
import com.sample.news.ui.viewmodels.NewsListBindingViewModel

class NewsListAdapter(val newsList: List<NewsObject>, val listener: OnNewsItemClickListener) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding: NewsListRowItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(p0.context), R.layout.news_list_row_item, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(newsList[p1])
    }

    public interface OnNewsItemClickListener {
        fun onClickNewsItem(newsObject: NewsObject)
    }


    inner class ViewHolder(private val newsListBinding: NewsListRowItemBinding) :
        RecyclerView.ViewHolder(newsListBinding.root) {
        fun bind(newsObject: NewsObject) {
            //val newsViewModel: NewsListBindingViewModel? = NewsListBindingViewModel()

           // newsViewModel?.bind(newsObject)
            newsListBinding.executePendingBindings()
            newsListBinding.newsObj = newsObject
            itemView.setOnClickListener { listener.onClickNewsItem(newsObject = newsObject) }

        }
    }
}