package com.saman.aparat.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.saman.aparat.api.ApiClient
import com.saman.aparat.api.IService
import com.saman.aparat.models.Video
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class VideoCatViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var videoCatList:MutableLiveData<List<Video>>

    fun catVideo(catId:String, from:Int,to:Int):MutableLiveData<List<Video>>{
        videoCatList= MutableLiveData()
        loadVideoCat(catId,from,to)
        return videoCatList
    }

    fun loadVideoCat(categoryId:String, mFrom:Int, mTo:Int){

        var iService:IService=ApiClient.retrofit.create(IService::class.java)
        iService.getVideosCategory(categoryId,mFrom,mTo).enqueue(object :Callback<List<Video>>{
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                videoCatList.value=response.body()
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {

            }

        })

    }
}