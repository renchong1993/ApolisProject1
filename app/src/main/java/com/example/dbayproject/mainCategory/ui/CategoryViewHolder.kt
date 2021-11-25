package com.example.dbayproject.mainCategory.ui


import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ViewHolderCategoryBinding
import com.example.dbayproject.mainCategory.model.CatData
import com.squareup.picasso.Picasso

class CategoryViewHolder(val binding: ViewHolderCategoryBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

    fun bindData(catData: CatData){
//        Picasso.get()
//            .load("http://rjtmobile.com/grocery/images/${catData.catImage}")
////            .load("https://placekitten.com/g/200/300")
////            .placeholder(R.drawable.ic_cart)
//            .error(R.drawable.ic_home)
//            .into(binding.imageviewCatPic)

        Glide.with(context)
            .load("https://rjtmobile.com/grocery/images/${catData.catImage}")
            .error(R.drawable.ic_home)
            .into(binding.imageviewCatPic)

        binding.textviewCatName.text = catData.catName

    }
}