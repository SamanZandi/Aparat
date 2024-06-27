package com.saman.aparat.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    val retrofit= Retrofit.Builder()
        .baseUrl("https://androidsupport.ir/pack/aparat/")
        .addConverterFactory(GsonConverterFactory.create())


        .build()



}