package com.example.dbayproject.product.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ViewHolderProductBinding
import com.example.dbayproject.product.model.ProdData
import com.squareup.picasso.Picasso

class ProductViewHolder(val binding: ViewHolderProductBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(prodData: ProdData){
        binding.textviewProdName.text = prodData.subName

        Picasso.get()
            .load("https://rjtmobile.com/grocery/images/"+prodData.subImage)
            .placeholder(R.drawable.ic_cart)
            .into(binding.imageviewProdPic)

        binding.buttonAddcart.setOnClickListener {

//            val sharedPreferences = getSharedPreferences("Cart", Context.MODE_PRIVATE)
//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//            editor.putString(prodData._id, +=1)
//            editor.apply()
        }
    }
}