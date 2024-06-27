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
import com.saman.aparat.db.AppDatabase
import com.saman.aparat.models.Video

class BestAdapter(mContext: Context, videol: List<Video>):
    RecyclerView.Adapter<BestAdapter.BestVH>()  {

    var context=mContext
    var videoList=videol


        class BestVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgBestVideo=itemView.findViewById<AppCompatImageView>(R.id.img_best_video)
            val txtBestTitle=itemView.findViewById<CustomTextView>(R.id.txt_best_title)
            val txtDuration=itemView.findViewById<CustomTextView>(R.id.txt_duration)
            val cardBest=itemView.findViewById<CardView>(R.id.card_best)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.best_row,null)
        return BestVH(view)
    }

    override fun onBindViewHolder(holder: BestVH, position: Int) {

        var video:Video=videoList.get(position)
        holder.imgBestVideo.load(video.icon)
        holder.txtBestTitle.setText(video.title)
        holder.txtDuration.setText(video.time)

        holder.cardBest.setOnClickListener {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("video", video)
            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
       return videoList.size
    }
}