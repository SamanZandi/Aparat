package com.saman.aparat.models

interface IMessageListener<T> {

    fun onSuccess(response: T,type : Int)
    fun  onFailure(errorResponse: String,type : Int)
  //  fun onSuccesss(id:String, response: T)
}