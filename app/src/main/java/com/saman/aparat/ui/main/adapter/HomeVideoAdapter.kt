package com.saman.aparat.ui.main.adapter

import android.content.Context
import android.content.Intent
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

class HomeVideoAdapter(mContext:Context, videol: List<Video>):
    RecyclerView.Adapter<HomeVideoAdapter.SpecialVH>() {

    var context=mContext
    var videoList=videol

    class SpecialVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imgSpecialVideo=itemView.findViewById<AppCompatImageView>(R.id.img_special_video)
        val txtSpecialTitle=itemView.findViewById<CustomTextView>(R.id.txt_special_title)
        val txtDuration=itemView.findViewById<CustomTextView>(R.id.txt_duration)
        val cardSpecial=itemView.findViewById<CardView>(R.id.card_special)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.home_video_row,null)
        return  SpecialVH(view)
    }

    override fun onBindViewHolder(holder: SpecialVH, position: Int) {

        var video:Video=videoList.get(position)
        holder.imgSpecialVideo.load(video.icon)
        holder.txtSpecialTitle.setText(video.title)

        holder.txtDuration.setText(video.time)




       holder.cardSpecial.setOnClickListener({
            var intent= Intent(context, VideoPlayerActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("video",video)
            context.startActivity(intent)
        })


    }

    override fun getItemCount(): Int {
        return videoList.size

    }
}