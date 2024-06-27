package com.saman.aparat.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.saman.aparat.Activity.VideoPlayerActivity
import com.saman.aparat.R
import com.saman.aparat.customView.CustomTextView
import com.saman.aparat.models.Video

class VideoAdapter(mContext: Context, videol: List<Video>): RecyclerView.Adapter<VideoAdapter.VideoVH>() {

    var context=mContext
    var videoList=videol

    class VideoVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgFavVideo=itemView.findViewById<AppCompatImageView>(R.id.img_fav_video)
        val txtFavTitle=itemView.findViewById<CustomTextView>(R.id.txt_fav_title)
        val txtDuration=itemView.findViewById<CustomTextView>(R.id.txt_duration)
// val cardFav=itemView.findViewById<CardView>(R.id.card_fav)
        val btn_watch=itemView.findViewById<AppCompatImageView>(R.id.btn_watch)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.favorite_row,null)
        return VideoVH(view)
    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) {
        val video:Video=videoList.get(position)
        holder.imgFavVideo.load(video.icon)
        holder.txtFavTitle.setText(video.title)
        holder.txtDuration.setText(video.time)


        holder.btn_watch.setOnClickListener {
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