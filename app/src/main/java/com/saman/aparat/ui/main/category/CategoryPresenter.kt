package com.saman.aparat.ui.main.category

import com.saman.aparat.api.ApiCaller
import com.saman.aparat.models.IMessageListener

class CategoryPresenter(var iview:categoryFragment):IMessageListener<Any> {

    var  apiCaller: ApiCaller = ApiCaller()
    fun loadCategory(type: Int){
        apiCaller.getCategories(type,this)
    }





    override fun onSuccess(response: Any, type: Int) {
        iview.onSuccess(response, type)

    }


    override fun onFailure(errorResponse: String, type: Int) {
        iview.onFailure(errorResponse,type)
    }



}