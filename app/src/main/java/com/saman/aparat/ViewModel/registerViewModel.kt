package com.saman.aparat.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.saman.aparat.User.LoginModel
import com.saman.aparat.api.ApiClient
import com.saman.aparat.api.IService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class registerViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var registerData: MutableLiveData<LoginModel>

    fun authentication(username:String, password:String):MutableLiveData<LoginModel>{
        registerData= MutableLiveData<LoginModel>()
        register(username,password)
        return registerData

    }


    private fun register(user:String, pass:String){
        val iService: IService = ApiClient.retrofit.create(IService ::class.java)
        iService.userRegister(user,pass).enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {

                registerData.value=response.body()
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {

                Log.e("", "onFailure: " )
                t.message.toString()
            }

        })
    }
}