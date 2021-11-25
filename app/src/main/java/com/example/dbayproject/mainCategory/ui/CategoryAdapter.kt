package com.example.dbayproject.mainCategory.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.databinding.ViewHolderCategoryBinding
import com.example.dbayproject.mainCategory.model.CatData


class CategoryAdapter(val catDatas: List<CatData>): RecyclerView.Adapter<CategoryViewHolder>() {

    lateinit var onCategorySelected:(CatData, Int) -> Unit

    fun setOnCategorySelectedListener(listener: (CatData, Int)->Unit){
        this.onCategorySelected = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val catData = catDatas[position]
        holder.bindData(catData)

        holder.itemView.setOnClickListener {
            if(this::onCategorySelected.isInitialized){
                onCategorySelected(catData, position)
            }
        }
    }

    override fun getItemCount() = catDatas.size
}