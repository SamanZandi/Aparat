package com.saman.aparat.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.saman.aparat.R
import com.saman.aparat.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

   lateinit var binding:ActivitySearchBinding

   var searchText:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBackSearch.setOnClickListener {
            finish()
        }

        binding.edtSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchText=p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })


        binding.edtSearch.setOnEditorActionListener { p0, p1, p2 ->
            val intent = Intent(applicationContext, SearchDetailActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("search", searchText)
            startActivity(intent)

            true
        }


    }
}