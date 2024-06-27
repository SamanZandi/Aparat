package com.saman.aparat.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.button.MaterialButton
import com.saman.aparat.Activity.VideoPlayerActivity
import com.saman.aparat.R
import com.saman.aparat.customView.CustomTextView
import com.saman.aparat.models.Video

class SearchAdapter(mContext: Context, list: List<Video>):
    RecyclerView.Adapter<SearchAdapter.SearchVH>() {

    var context=mContext
    var videoList=list


    class SearchVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgSearch=itemView.findViewById<AppCompatImageView>(R.id.img_search)
        val txtSearch=itemView.findViewById<CustomTextView>(R.id.txt_search)
        val cardSearch=itemView.findViewById<CardView>(R.id.card_search)
        val btnWatch=itemView.findViewById<AppCompatImageView>(R.id.btn_watch)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.SearchVH {
        var view:View= LayoutInflater.from(context).inflate(R.layout.search_row,null)
        return SearchVH(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchVH, position: Int) {
        var video:Video=videoList.get(position)
       holder.imgSearch.load(video.icon)
        holder.txtSearch.setText(video.title)



        holder.btnWatch.setOnClickListener {
            var intent= Intent(context, VideoPlayerActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("video",video)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
       return videoList.size
    }


}