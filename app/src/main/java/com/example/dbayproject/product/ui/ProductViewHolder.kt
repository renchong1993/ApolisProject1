package com.example.dbayproject.product.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ViewHolderProductBinding
import com.example.dbayproject.product.model.ProdData
//import com.example.dbayproject.product.model.ProdDao
//import com.example.dbayproject.product.model.ProductDatase
import com.squareup.picasso.Picasso

class ProductViewHolder(val binding: ViewHolderProductBinding): RecyclerView.ViewHolder(binding.root) {
//    val room = ProductDatase.getDatabase()

//    val sharedPreferences = ProdUtils.context.getSharedPreferences("Cart", Context.MODE_PRIVATE)
//    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun bindData(prodData: ProdData){
        binding.textviewProdName.text = prodData.productName
        binding.textviewProdPrice.text = "$ ${prodData.price.toString()}"

        Picasso.get()
            .load("https://rjtmobile.com/grocery/images/"+prodData.image)
            .placeholder(R.drawable.ic_cart)
            .into(binding.imageviewProdPic)

    }
}