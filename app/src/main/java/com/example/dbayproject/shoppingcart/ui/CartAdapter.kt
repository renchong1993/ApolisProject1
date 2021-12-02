package com.example.dbayproject.shoppingcart.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbayproject.databinding.ViewHolderCartBinding
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.shoppingcart.model.CartProduct

class CartAdapter(val cartProducts: ArrayList<CartProduct>): RecyclerView.Adapter<CartViewHolder> (){

    lateinit var onCartProdSelected:(CartProduct, Int) -> Unit
    fun setOnCartProdSelectedListener(listener: (CartProduct, Int)->Unit){
        this.onCartProdSelected = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCartBinding.inflate(layoutInflater, parent, false)

        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindData(cartProducts[position])

        holder.itemView.setOnClickListener {
            if (this::onCartProdSelected.isInitialized){
                onCartProdSelected(cartProducts[position], position)
            }
        }
    }

    override fun getItemCount() = cartProducts.size

}