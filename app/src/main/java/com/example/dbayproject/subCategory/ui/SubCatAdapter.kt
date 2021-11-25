package com.example.dbayproject.subCategory.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.databinding.ViewHolderSubcatBinding
import com.example.dbayproject.subCategory.model.SubCatData

class SubCatAdapter(val subCatDatas: List<SubCatData>):RecyclerView.Adapter<SubCatViewHolder>() {

    lateinit var onCategorySelected:(SubCatData, Int) -> Unit

    fun setOnCategorySelectedListener(listener: (SubCatData, Int)->Unit){
        this.onCategorySelected = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderSubcatBinding.inflate(layoutInflater, parent, false)
        return SubCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCatViewHolder, position: Int) {
        val subCatData = subCatDatas[position]
        holder.bindData(subCatData)

        holder.itemView.setOnClickListener {
            if(this::onCategorySelected.isInitialized){
                onCategorySelected(subCatData, position)
            }
        }
    }

    override fun getItemCount() = subCatDatas.size

}