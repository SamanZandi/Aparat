package com.saman.aparat.models

interface IView<in T> {

    fun onSuccess(response: T, type : Int)
    fun  onFailure(errorResponse: String,type : Int)
    fun onError(responseMessage: String)
}