package com.sample.news.UI.NewsList

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.news.R
import com.sample.news.Service.Model.NewsObject
import com.sample.news.databinding.RowItemNewsListBinding
import com.sample.news.UI.ViewModels.NewsListBindingViewModel

class NewsListAdapter(val newsList:MutableList<NewsObject>): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding : RowItemNewsListBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context), R.layout.row_item_news_list, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(newsList[p1])
    }

    inner class ViewHolder(private val newsListBinding: RowItemNewsListBinding):RecyclerView.ViewHolder(newsListBinding.root){
        fun bind(newsObject: NewsObject) {

            val newsViewModel:NewsListBindingViewModel? = NewsListBindingViewModel()

            newsViewModel?.bind(newsObject)
           newsListBinding.viewModel = newsViewModel
        }
    }
}