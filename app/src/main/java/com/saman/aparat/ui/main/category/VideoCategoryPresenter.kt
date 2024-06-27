package com.saman.aparat.ui.main.category

import com.saman.aparat.api.ApiCaller
import com.saman.aparat.models.IMessageListener

class VideoCategoryPresenter(var iview:categoryFragment): IMessageListener<Any> {

    var  apiCaller: ApiCaller = ApiCaller()


    override fun onSuccess(response: Any, type: Int) {
       iview.onSuccess(response, type)
    }

    override fun onFailure(errorResponse: String, type: Int) {
        iview.onFailure("",type)
    }


}