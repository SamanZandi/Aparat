package com.saman.aparat.ui.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.saman.aparat.Activity.VideoByCategoryActivity
import com.saman.aparat.Activity.VideoPlayerActivity
import com.saman.aparat.R
import com.saman.aparat.customView.CustomTextView
import com.saman.aparat.models.Category
import com.saman.aparat.models.Video

class VideoByCategoryAdapter(mContext: Context, videoLst: List<Video>):
    RecyclerView.Adapter<VideoByCategoryAdapter.videoCategoryVH>() {

    var context=mContext
    var videoList=videoLst

    class videoCategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgVideoCat=itemView.findViewById<AppCompatImageView>(R.id.img_video_cat)
        val txtVideoCat=itemView.findViewById<CustomTextView>(R.id.txt_video_cat)
     //   val txtDuration=itemView.findViewById<CustomTextView>(R.id.txt_duration)
        val cardVideoCat=itemView.findViewById<CardView>(R.id.card_video_cat)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): videoCategoryVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.videocat_row,null)
        return videoCategoryVH(view)
    }

    override fun onBindViewHolder(holder: videoCategoryVH, position: Int) {
        val video: Video =videoList.get(position)
        holder.imgVideoCat.load(video.icon)
        holder.txtVideoCat.setText(video.title)
      //  holder.txtDuration.setText(video.time)

        holder.cardVideoCat.setOnClickListener {
            val intent= Intent(context, VideoPlayerActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("video",video)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}