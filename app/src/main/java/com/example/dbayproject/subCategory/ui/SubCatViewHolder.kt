package com.example.dbayproject.subCategory.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.R
import com.example.dbayproject.databinding.FragmentSubCatBinding
import com.example.dbayproject.databinding.ViewHolderSubcatBinding
import com.example.dbayproject.subCategory.model.SubCatData
import com.squareup.picasso.Picasso

class SubCatViewHolder(val binding: ViewHolderSubcatBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(subCatData: SubCatData){
        Picasso.get()
            .load("https://rjtmobile.com/grocery/images/"+subCatData.subImage)
            .placeholder(R.drawable.ic_cart)
            .into(binding.imageviewSubCatPic)

        binding.textviewSubCatName.text = subCatData.subName

    }
}