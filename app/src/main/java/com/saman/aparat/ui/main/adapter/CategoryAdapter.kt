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
import com.saman.aparat.Activity.VideoByCategoryActivity
import com.saman.aparat.R
import com.saman.aparat.customView.CustomTextView
import com.saman.aparat.models.Category
import com.saman.aparat.models.Video

class CategoryAdapter(mContext: Context, catList: List<Category>):
    RecyclerView.Adapter<CategoryAdapter.categoryVH>() {

    val context=mContext
    val categoryList=catList


    class categoryVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imgCategory=itemView.findViewById<AppCompatImageView>(R.id.img_category)
        val titleCategory=itemView.findViewById<CustomTextView>(R.id.title_category)
        val cardCategory=itemView.findViewById<CardView>(R.id.card_category)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryVH {
        val view:View= LayoutInflater.from(context).inflate(R.layout.category_row,null)
        return categoryVH(view)
    }

    override fun onBindViewHolder(holder: categoryVH, position: Int) {
        var category: Category =categoryList.get(position)


        holder.imgCategory.load(category.icon)
        holder.titleCategory.setText(category.title)

        holder.cardCategory.setOnClickListener {
            var intent=Intent(context, VideoByCategoryActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("categoryVideo",category)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return categoryList.size
    }
}