package com.example.dbayproject.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.databinding.ViewHolderProductBinding
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.subCategory.model.SubCatData

class ProductAdapter(val prodDatas: List<ProdData>): RecyclerView.Adapter<ProductViewHolder>() {

    lateinit var onCategorySelected:(SubCatData, Int) -> Unit

    fun setOnCategorySelectedListener(listener: (SubCatData, Int)->Unit){
        this.onCategorySelected = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindData(prodDatas[position])
    }

    override fun getItemCount() = prodDatas.size

}