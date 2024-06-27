package com.saman.aparat.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.saman.aparat.ViewModel.VideoCatViewModel

import com.saman.aparat.databinding.ActivityVideoByCategoryBinding
import com.saman.aparat.models.Category

import com.saman.aparat.models.Video
import com.saman.aparat.ui.main.adapter.*
import com.saman.aparat.ui.main.category.categoryFragment


class VideoByCategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideoByCategoryBinding
    lateinit var bundle: Bundle
    lateinit var category: Category
    lateinit var viewModel: VideoCatViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoByCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bundle = intent.extras!!
        category = bundle.getParcelable("categoryVideo")!!
        binding.categoryTitle.setText(category.title)


        var catId: String = category.id
        var from: Int = 1
        var to: Int = 8

        viewModel =ViewModelProvider(this).get(VideoCatViewModel::class.java)

        viewModel.catVideo(catId,from,to).observe(this,object :Observer<List<Video>>{
            override fun onChanged(t: List<Video>?) {
                Log.e("", " ")

                if(t!=null){
                    binding.recyclerVideoCat.adapter=VideoAdapter(applicationContext,t)
                    binding.recyclerVideoCat.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
               if(t.size==0){
                   binding.recyclerVideoCat.visibility=View.GONE
                   binding.noImg.visibility=View.VISIBLE
                   binding.txtNodata.visibility=View.VISIBLE
               }
                }




            }

        })


            binding.imgBack.setOnClickListener {
            finish()
            }

    }
}



