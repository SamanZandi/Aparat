package com.saman.aparat.ui.main.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.saman.aparat.databinding.FragmentHomeBinding
import com.saman.aparat.models.IView
import com.saman.aparat.models.NewsItem
import com.saman.aparat.models.Video
import com.saman.aparat.ui.main.adapter.BestAdapter
import com.saman.aparat.ui.main.adapter.NewAdapter
import com.saman.aparat.ui.main.adapter.NewsAdapter
import com.saman.aparat.ui.main.adapter.HomeVideoAdapter


class HomeFragment : Fragment(),IView<Any> {

    lateinit var binding: FragmentHomeBinding
    var homePresenter = HomePresenter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePresenter.loadSpecials(1)
        homePresenter.loadBests(2)
        homePresenter.loadNewVideos(3)
        homePresenter.loadNewsBanner(4)


    }


    override fun onError(responseMessage: String) {
        Log.d(TAG, "onSuccess: ")

    }


    override fun onSuccess(response: Any, type: Int) {
        when (response) {
            is List<*> -> {

                if (type == 1) {

                    binding.recyclerSpecial.adapter = HomeVideoAdapter(
                        requireContext(),
                        response as List<Video>
                    )
                    binding.recyclerSpecial.layoutManager =
                        GridLayoutManager(requireContext(), 2)

                } else if (type == 2) {
                    binding.recyclerBest.adapter = HomeVideoAdapter(
                        requireContext(),
                        response as List<Video>
                    )
                    binding.recyclerBest.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                } else if (type == 3) {
                    binding.recyclerNewVideo.adapter = HomeVideoAdapter(
                        requireContext(),
                        response as List<Video>
                    )
                    binding.recyclerNewVideo.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                } else if (type == 4) {
                    binding.newsPager.adapter = NewsAdapter(requireActivity(), response as List<NewsItem>)

                }
            }
        }

        binding.newsPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { /*empty*/
            }

            override fun onPageSelected(position: Int) {
                binding.indicator.setSelection(position)
            }

            override fun onPageScrollStateChanged(state: Int) { /*empty*/
            }
        })

    }

    override fun onFailure(errorResponse: String, type: Int) {


    }


}