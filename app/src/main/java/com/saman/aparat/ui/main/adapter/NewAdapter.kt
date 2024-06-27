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

class NewAdapter(mContext: Context, videol: List<Video>):
    RecyclerView.Adapter<NewAdapter.NewVH>() {

    var context=mContext
    var videoList=videol

        class NewVH(itemView: View) : RecyclerView.ViewHolder(itemView){
            val imgNewVideo=itemView.findViewById<AppCompatImageView>(R.id.img_new_video)
            val txtNewTitle=itemView.findViewById<CustomTextView>(R.id.txt_new_title)
            val txtDuration=itemView.findViewById<CustomTextView>(R.id.txt_duration)
            val cardNew=itemView.findViewById<CardView>(R.id.card_new)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.new_row,null)
        return NewVH(view)
    }

    override fun onBindViewHolder(holder: NewVH, position: Int) {
        var video:Video=videoList.get(position)
        holder.imgNewVideo.load(video.icon)
        holder.txtNewTitle.setText(video.title)
        holder.txtDuration.setText(video.time)

        holder.cardNew.setOnClickListener({
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