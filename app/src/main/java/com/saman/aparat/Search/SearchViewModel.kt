package com.saman.aparat.Search

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.MutableLiveData
import com.saman.aparat.api.ApiClient
import com.saman.aparat.api.IService
import com.saman.aparat.models.Video
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchViewModel(application: Application) :AndroidViewModel(application) {

     lateinit var searchList: MutableLiveData<List<Video>>

    fun searchVideos(name: String): MutableLiveData<List<Video>> {

        searchList = MutableLiveData()
        loadVideos(name)
        return searchList
    }

    fun loadVideos(videoName: String) {

        var iService: IService = ApiClient.retrofit.create(IService::class.java)
        iService.searchVideo(videoName).enqueue(object : Callback<List<Video>> {
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                searchList.value = response.body()
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {

            }

        })
    }
}