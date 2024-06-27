package com.saman.aparat.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.saman.aparat.Search.SearchViewModel
import com.saman.aparat.databinding.ActivitySearchDetailBinding
import com.saman.aparat.models.Video
import com.saman.aparat.ui.main.adapter.*



class SearchDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchDetailBinding
    lateinit var bundle: Bundle
    lateinit var viewModel: SearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras!!

        var searchText: String = bundle.getString("search")!!
        Log.e("search", "${searchText} ")

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        viewModel.searchVideos(searchText).observe(this, object : Observer<List<Video>> {

            override fun onChanged(t: List<Video>) {
                Log.e("", " ")
                binding.searchFound.setText(t.size.toString())
                if (t != null) {

                    binding.recyclerSearch.adapter = SearchAdapter(applicationContext, t)
                    binding.recyclerSearch.layoutManager =
                        LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                }
                if(t.size==0){
                    binding.recyclerSearch.visibility=View.GONE
                    binding.noImg.visibility=View.VISIBLE
                    binding.txtNodata.visibility=View.VISIBLE

                }
            }
        })
    }
}


