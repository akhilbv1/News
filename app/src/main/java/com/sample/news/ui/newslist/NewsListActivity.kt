package com.sample.news.ui.newslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.sample.news.R
import com.sample.news.service_retrofit.model.NewsObject
import com.sample.news.ui.newsdetails.NewsDetailsActivity
import com.sample.news.ui.viewmodels.NewsListViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewsListActivity : DaggerAppCompatActivity(), NewsListAdapter.OnNewsItemClickListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rec: RecyclerView = findViewById(R.id.recNews)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rec.layoutManager = layoutManager
        val viewModel = ViewModelProviders.of(this, viewModelFactory)[NewsListViewModel::class.java]
        viewModel.getNewsList()
        viewModel.getSuccessLiveData().observe(this, Observer { t: List<NewsObject>? ->
            val newsListAdapter = NewsListAdapter(t!!,this)
            rec.adapter = newsListAdapter
        })
        viewModel.getErrorLiveData().observe(this, Observer { t ->
            t?.printStackTrace()
            Toast.makeText(this@NewsListActivity,"Error Occured",Toast.LENGTH_SHORT).show()

        })
    }
    override fun onClickNewsItem(newsObject: NewsObject) {
     val intent = Intent(this@NewsListActivity,NewsDetailsActivity::class.java)
        intent.putExtra("NewsdetailsObject",newsObject)
        startActivity(intent)
    }
}