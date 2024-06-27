package com.saman.aparat.api

import com.saman.aparat.User.LoginModel
import com.saman.aparat.models.Category
import com.saman.aparat.models.NewsItem
import com.saman.aparat.models.Video
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IService {

    @GET("getSpecial.php")
    fun getSpecial() : Call<List<Video>>

    @GET("getBestVideos.php")
    fun getBestVideos(): Call<List<Video>>

    @GET("getCategory.php")
    fun getCategories():Call<List<Category>>


    @GET("getNewVideos.php")
    fun getNewVideos():Call<List<Video>>

    @GET("getNews.php")
    fun getNews():Call<List<NewsItem>>


    @GET("search.php")
    fun searchVideo(@Query("title") searchText:String):Call<List<Video>>

    @POST("getVideosCategory.php")
    @FormUrlEncoded
    fun getVideosCategory(@Field("catId") catId: String,
                          @Field("from") from: Int,
                          @Field("to") to: Int): Call<List<Video>>


    @POST("login.php")
    @FormUrlEncoded
    fun login(@Field("username") user:String,
              @Field("password") pass:String):Call<LoginModel>


    @POST("register.php")
    @FormUrlEncoded
    fun userRegister(@Field("username") user:String,
              @Field("password") pass:String):Call<LoginModel>

}