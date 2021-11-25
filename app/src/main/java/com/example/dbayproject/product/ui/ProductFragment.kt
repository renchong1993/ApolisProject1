package com.example.dbayproject.product.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.Communicator
import com.example.dbayproject.R
import com.example.dbayproject.databinding.FragmentProductBinding
import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.product.presenter.ProductContractor
import com.example.dbayproject.product.presenter.ProductPresenter

class ProductsFragment() : Fragment(), ProductContractor.View {

    lateinit var presenter: ProductPresenter
    lateinit var adapter: ProductAdapter
    lateinit var binding: FragmentProductBinding
    lateinit var communicator: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentProductBinding.inflate(inflater,container, false)
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)

        communicator = activity as Communicator
        presenter = ProductPresenter(this, requireContext())
        presenter.getAllProduct(arguments?.getInt("subCategoryID")!!)

        return binding.root
    }

    override fun setData(prodDatas: List<ProdData>) {
        adapter = ProductAdapter(prodDatas)


        binding.recyclerview.adapter = adapter
    }

    override fun setEmpty() {
        TODO("Not yet implemented")
    }

    override fun setResult(message: String) {
        TODO("Not yet implemented")
    }

    override fun onLoad(boolean: Boolean) {
        TODO("Not yet implemented")
    }

}