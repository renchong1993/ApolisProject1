package com.example.dbayproject.subCategory.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.Communicator
import com.example.dbayproject.R
import com.example.dbayproject.databinding.FragmentSubCatBinding
import com.example.dbayproject.subCategory.model.SubCatData
import com.example.dbayproject.subCategory.presenter.SubCatContract
import com.example.dbayproject.subCategory.presenter.SubCatPresenter

class SubCatFragment() : Fragment(), SubCatContract.View {

    lateinit var presenter: SubCatPresenter
    lateinit var adapter: SubCatAdapter
    lateinit var binding: FragmentSubCatBinding
    lateinit var communicator: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSubCatBinding.inflate(inflater, container, false)
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)

        communicator = activity as Communicator
        presenter = SubCatPresenter(this, requireContext())
        presenter.getSubCatData(arguments?.getInt("categoryID")!!)

        return binding.root
    }

    override fun setData(subCatDatas: List<SubCatData>) {
        adapter = SubCatAdapter(subCatDatas)

        adapter.setOnCategorySelectedListener { subCatData, position ->
            communicator.toProd(subCatData)
        }

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