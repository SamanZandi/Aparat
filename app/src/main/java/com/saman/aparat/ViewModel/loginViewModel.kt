package com.saman.aparat.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.saman.aparat.User.LoginModel
import com.saman.aparat.api.ApiClient
import com.saman.aparat.api.IService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var loginData:MutableLiveData<LoginModel>

    fun authentication(username:String, password:String):MutableLiveData<LoginModel>{
        loginData= MutableLiveData<LoginModel>()
        login(username,password)
        return loginData

    }


   private fun login(username:String, password:String){
        val iService:IService=ApiClient.retrofit.create(IService ::class.java)
        iService.login(username,password).enqueue(object :Callback<LoginModel>{
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
            loginData.value=response.body()
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.e("", "onFailure: " )
            }

        })
    }

}