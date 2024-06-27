package com.saman.aparat.api

import com.saman.aparat.User.LoginModel
import com.saman.aparat.models.Category
import com.saman.aparat.models.IMessageListener
import com.saman.aparat.models.NewsItem
import com.saman.aparat.models.Video
import com.saman.aparat.ui.main.category.CategoryPresenter
import com.saman.aparat.ui.main.home.HomePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {

    val iService: IService = ApiClient.retrofit.create(IService::class.java)

    fun getSpecial(type: Int, listener: HomePresenter) {
        iService.getSpecial().enqueue(object : Callback<List<Video>> {
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {

                response.body()?.let { listener.onSuccess(it, type) }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
                listener.onFailure("",type)

            }

        })
    }

    fun getBestVideo(type: Int, listener: HomePresenter) {
        iService.getBestVideos().enqueue(object : Callback<List<Video>> {


            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                response.body()?.let { listener.onSuccess(it, type) }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
                listener.onFailure("",type)
            }

        })
    }

    fun getCategories(type: Int, listener: CategoryPresenter) {
        iService.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                response.body()?.let { listener.onSuccess(it, type) }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                listener.onFailure("",type)
            }


        })

    }

    fun getNewVideos(type: Int, listener: HomePresenter) {
        iService.getNewVideos().enqueue(object :Callback<List<Video>>{
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                response.body()?.let { listener.onSuccess(it,type) }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
               listener.onFailure("",type)
            }


        })
    }


    fun getNews(type: Int, listener: HomePresenter) {
        iService.getNews().enqueue(object :Callback<List<NewsItem>>{
            override fun onResponse(call: Call<List<NewsItem>>, response: Response<List<NewsItem>>) {
                response.body()?.let { listener.onSuccess(it,type) }
            }

            override fun onFailure(call: Call<List<NewsItem>>, t: Throwable) {
                listener.onFailure("",type)
            }


        })
    }

    fun searchVideos(search:String,listener:IMessageListener<List<Video>>){
        iService.searchVideo(search).enqueue(object :Callback<List<Video>>{
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                response.body()?.let { listener.onSuccess(it,0) }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {

            }

        })
    }


    fun getVideosCategory(catId: String, from: Int, to: Int, listener: IMessageListener<List<Video>>){
        iService.getVideosCategory(catId,from, to).enqueue(object : Callback<List<Video>>{
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                response.body()?.let {listener.onSuccess(it, 4) }

            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {

               listener.onFailure("",4)

            }

        })
    }


    fun login(username: String, password:String, listener: IMessageListener<LoginModel>){
        iService.login(username,password).enqueue(object :Callback<LoginModel>{
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                response.body()?.let { listener.onSuccess(it,5) }

            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {

            }

        })

    }


    fun register(username: String, password:String, listener: IMessageListener<LoginModel>){
        iService.userRegister(username,password).enqueue(object :Callback<LoginModel>{
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                response.body()?.let { listener.onSuccess(it,6) }

            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {

            }

        })

    }


}



