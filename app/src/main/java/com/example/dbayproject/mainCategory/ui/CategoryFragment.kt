package com.example.dbayproject.mainCategory.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.Communicator
import com.example.dbayproject.R
import com.example.dbayproject.databinding.FragmentCategoryBinding
import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.mainCategory.presenter.CatPresenter
import com.example.dbayproject.mainCategory.presenter.MainCatContractor
import com.example.dbayproject.subCategory.ui.SubCatFragment

class CategoryFragment : Fragment(), MainCatContractor.View {

    lateinit var presenter: CatPresenter
    lateinit var adapter: CategoryAdapter
    lateinit var binding: FragmentCategoryBinding
    lateinit var communicator: Communicator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)

        communicator = activity as Communicator
        presenter = CatPresenter(this, requireContext())
        presenter.getAllCatData()

        return binding.root
    }

    override fun setData(catDatas: List<CatData>) {
        adapter = CategoryAdapter(catDatas)

        adapter.setOnCategorySelectedListener { catData, position ->
           communicator.toSubCat(catData)

        }

        Log.d("CatSD", "$catDatas")
        binding.recyclerview.adapter = adapter
    }

    override fun setEmpty() {
        Toast.makeText(context, "Error, please reload", Toast.LENGTH_SHORT).show()
        onDetach()
    }

    override fun setResult(message: String) {
        TODO("Not yet implemented")
    }

    override fun onLoad(boolean: Boolean) {
        TODO("Not yet implemented")
    }

}