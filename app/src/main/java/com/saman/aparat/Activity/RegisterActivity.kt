package com.saman.aparat.Activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.saman.aparat.User.LoginModel
import com.saman.aparat.ViewModel.registerViewModel
import com.saman.aparat.databinding.ActivityRegisterBinding
import com.saman.aparat.models.state

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: registerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this)[registerViewModel::class.java]

        binding.btnRegister.setOnClickListener { it ->
            val username:String=binding.edtUser.text.toString()
            val password:String=binding.edtPassword.text.toString()
            viewModel.authentication(username,password).observe(this, object : Observer<LoginModel> {
                override fun onChanged(t: LoginModel?) {
                    val registerVM=it


                        if(t!!.code.code.equals(state.SUCCESS.state)){
                            Log.e("", "onChanged:\"${t}\" ")
                            Toast.makeText(applicationContext,"ثبت نام کاربر با موفقیت انجام شد",Toast.LENGTH_LONG).show()

                    }
                }

            })
        }



    }
}