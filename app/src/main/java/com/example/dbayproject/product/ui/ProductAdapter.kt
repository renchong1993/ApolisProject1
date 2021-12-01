package com.example.dbayproject.product.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.databinding.ViewHolderProductBinding
import com.example.dbayproject.product.model.ProdData

class ProductAdapter(val prodDatas: List<ProdData>): RecyclerView.Adapter<ProductViewHolder>() {

    lateinit var addToCartListener:(ProdData, Int, String) -> Unit
    fun setAddToCartClickListener(listener: (ProdData, Int, String)->Unit){
        this.addToCartListener = listener
    }

//    lateinit var onCategorySelected:(SubCatData, Int) -> Unit
//    fun setOnCategorySelectedListener(listener: (SubCatData, Int)->Unit){
//        this.onCategorySelected = listener
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindData(prodDatas[position])

        holder.binding.buttonAddcart.setOnClickListener {
            if(this::addToCartListener.isInitialized){
                addToCartListener(prodDatas[position], position, holder.binding.edittextProductQty.text.toString())
                Log.d("PassingCart","${prodDatas[position]}")
            }
        }
    }

    override fun getItemCount() = prodDatas.size
}