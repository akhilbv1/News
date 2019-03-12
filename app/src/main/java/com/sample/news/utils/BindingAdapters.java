package com.sample.news.utils;

import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView ivNewsLog,String imageUrl){
        Glide.with(ivNewsLog.getContext()).load(imageUrl).into(ivNewsLog);
    }

    @BindingAdapter("NewsdetailsUrl")
    public static void setWebviewUrl(WebView webviewUrl,String webViewUrl){
        webviewUrl.loadUrl(webViewUrl);
    }
}
