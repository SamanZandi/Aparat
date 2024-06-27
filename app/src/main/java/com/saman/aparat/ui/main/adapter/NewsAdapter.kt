package com.saman.aparat.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import coil.load
import com.saman.aparat.R
import com.saman.aparat.customView.CustomTextView
import com.saman.aparat.models.NewsItem


class NewsAdapter(mContext:Context, newslst:List<NewsItem>):PagerAdapter() {

    var context=mContext
    var newsList=newslst
    override fun getCount(): Int {
        return newsList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.news_row, null)
        val imgNews = view.findViewById<AppCompatImageView>(R.id.img_news)
        val txtNews = view.findViewById<CustomTextView>(R.id.txt_news)
        container.addView(view, 0)
        val news: NewsItem = newsList.get(position)

        imgNews.load(news.icon)
        txtNews.setText(news.title)
        imgNews.setOnClickListener {
            val url = news.link
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }


        return view
    }


}