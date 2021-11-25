package com.example.dbayproject.shoppingcart.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ViewHolderCartBinding
import com.example.dbayproject.product.model.ProdData
import com.squareup.picasso.Picasso

class CartViewHolder(val binding: ViewHolderCartBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(prodData: ProdData){
        Picasso.get()
            .load("https://rjtmobile.com/grocery/images/"+prodData.subImage)
            .placeholder(R.drawable.ic_cart)
            .into(binding.imageviewProdPic)


    }
}