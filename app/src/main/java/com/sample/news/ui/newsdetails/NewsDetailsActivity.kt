package com.sample.news.ui.newsdetails

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sample.news.R
import com.sample.news.databinding.NewsDetailsBinding
import com.sample.news.service_retrofit.model.NewsObject

class NewsDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:NewsDetailsBinding = DataBindingUtil.setContentView(this, R.layout.news_details)
        val newsDetails:NewsObject = intent.getParcelableExtra("NewsdetailsObject")
        binding.newsObj = newsDetails
    }
}