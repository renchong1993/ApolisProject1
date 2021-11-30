package com.example.dbayproject.shoppingcart.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.DatabaseHandler
import com.example.dbayproject.databinding.FragmentCartBinding
import com.example.dbayproject.shoppingcart.model.CartProduct


class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding
    lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentCartBinding.inflate(inflater,container,false)
        binding.recyclerviewCartProduct.layoutManager = LinearLayoutManager(activity)

        val databaseHandler = createDataBaseHandler()
        val cart = databaseHandler.getAllProducts()
        adapter = CartAdapter(cart)
        binding.recyclerviewCartProduct.adapter = adapter

        binding.apply {
            textviewItemtotalPrice.text = getTotal(cart).toString()
            textviewTaxPrice.text = (getTotal(cart)*0.1).toString()
//            textviewSubtotalPrice.text = (textviewItemtotalPrice.text as Float + textviewTaxPrice.text as Float).toString()
        }

        return binding.root
    }

    private fun getTotal(cart: List<CartProduct>): Float {
        var itemTotal: Float = 0f
//        cart.forEach()
/////////////////////////////////////

        return itemTotal
    }


    private fun createDataBaseHandler(): DatabaseHandler {
        return DatabaseHandler(requireContext())
    }

}