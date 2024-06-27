package com.saman.aparat.ui.main.favorite

import android.annotation.SuppressLint
import android.content.Intent.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.saman.aparat.databinding.FragmentFavoriteBinding
import com.saman.aparat.db.AppDatabase
import com.saman.aparat.models.Video
import com.saman.aparat.ui.main.adapter.VideoAdapter


class FavoriteFragment : Fragment() {


    lateinit var binding: FragmentFavoriteBinding

    lateinit var myDB: AppDatabase

    lateinit var favoriteList:List<Video>




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater)

        myDB = activity?.let { AppDatabase.getInstance(it) }!!

          favoriteList=myDB.idao().getVideoList()

            if(favoriteList.size==0){
                binding.noImg.visibility=View.VISIBLE
                binding.txtNodata.visibility=View.VISIBLE

            }else {

                binding.recyclerFavorite.adapter =
                    VideoAdapter(requireContext(), myDB.idao().getVideoList())
                binding.recyclerFavorite.layoutManager =
                    LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            }


            return binding.root

        }



}