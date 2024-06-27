package com.saman.aparat.ui.main.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.saman.aparat.R
import com.saman.aparat.databinding.FragmentCategoryBinding
import com.saman.aparat.databinding.FragmentHomeBinding
import com.saman.aparat.models.Category
import com.saman.aparat.models.IView
import com.saman.aparat.ui.main.adapter.CategoryAdapter


class categoryFragment : Fragment(), IView<Any> {



    lateinit var binding:FragmentCategoryBinding
    var categoryPresenter=CategoryPresenter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryPresenter.loadCategory(3)
    }

    override fun onSuccess(response: Any, type: Int) {
        when(response){
            is List<*>->{
          binding.recyclerCategory.adapter=CategoryAdapter(requireContext()
              , response as List<Category>)
          binding.recyclerCategory.layoutManager=GridLayoutManager(requireContext(),2)

            }

        }

    }

    override fun onFailure(errorResponse: String, type: Int) {

    }

    override fun onError(responseMessage: String) {

    }






}