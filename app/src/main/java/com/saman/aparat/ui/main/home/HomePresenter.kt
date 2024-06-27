package com.saman.aparat.ui.main.home

import com.saman.aparat.api.ApiCaller
import com.saman.aparat.models.IMessageListener

class HomePresenter(var iview: HomeFragment):IMessageListener<Any> {

    var  apiCaller: ApiCaller = ApiCaller()
    fun loadSpecials(type : Int){
        apiCaller.getSpecial(type,this)
    }

    fun loadBests(type : Int){
        apiCaller.getBestVideo(type, this)
    }

    fun loadNewVideos(type: Int) {
        apiCaller.getNewVideos(type,this)
    }


    fun loadNewsBanner(type: Int){
        apiCaller.getNews(type,this)
    }

    override fun onSuccess(response: Any,type : Int) {
        iview.onSuccess(response,type)
    }



    override fun onFailure(errorResponse: String, type: Int) {
        iview.onFailure(errorResponse,type)
    }



}