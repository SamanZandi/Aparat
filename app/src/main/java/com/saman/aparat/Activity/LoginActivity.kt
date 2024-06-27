package com.saman.aparat.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saman.aparat.MainActivity
import com.saman.aparat.R
import com.saman.aparat.User.LoginModel
import com.saman.aparat.ViewModel.loginViewModel
import com.saman.aparat.databinding.ActivityLoginBinding
import com.saman.aparat.models.state

class LoginActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginBinding
    lateinit var viewModel:loginViewModel
    lateinit var loginV:LoginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       viewModel=ViewModelProvider(this).get(loginViewModel::class.java)


        binding.btnLogin.setOnClickListener {
            val user:String=binding.edtUser.text.toString()
            val password:String=binding.edtPassword.text.toString()

            /*val intent=Intent(applicationContext,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)*/

            viewModel.authentication(user,password).observe(this, Observer<LoginModel>{

                  //  val loginVM=it

          /*      if (loginV.code.code==state.SUCCESS.state) {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }*/



            })
        }

        binding.btnReg.setOnClickListener {
            val intent=Intent(applicationContext,RegisterActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }
}