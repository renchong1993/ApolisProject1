package com.example.dbayproject.shoppingcart.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.DatabaseHandler
import com.example.dbayproject.MainActivity
import com.example.dbayproject.databinding.FragmentCartBinding
import com.example.dbayproject.login.model.User
import com.example.dbayproject.login.model.UserX
import com.example.dbayproject.orders.model.*
import com.example.dbayproject.orders.presenter.OrderPresenter
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.product.ui.ProductAdapter
import com.example.dbayproject.shoppingcart.model.CartProduct
import java.util.*
import kotlin.collections.ArrayList

class CartFragment(private val sharedPreferences: SharedPreferences) : Fragment(){

    lateinit var binding: FragmentCartBinding
    lateinit var adapter: CartAdapter
    lateinit var presenter: OrderPresenter


    var cart = ArrayList<CartProduct>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentCartBinding.inflate(inflater,container,false)
        binding.recyclerviewCartProduct.layoutManager = LinearLayoutManager(activity)


        presenter = OrderPresenter(this, requireContext())

        val databaseHandler = createDataBaseHandler()
        cart = databaseHandler.getAllProducts()

        adapter = CartAdapter(cart)

        adapter.setOnCartProdSelectedListener { product, position->
            val res = databaseHandler.deleteProduct(product)
            if (res>0){
                Log.i("AddCart", "${product.Name} has been deleted from cart")
                Toast.makeText(context, "Item ${product.Name} has been deleted from cart", Toast.LENGTH_SHORT).show()

                cart.removeAt(position)
                adapter.notifyDataSetChanged()
                updatePrice()
            }
        }

        binding.buttonSubmitOrder.setOnClickListener {
            val orderSummary = OrderSummary(
                0,
                0,
                getTotal(cart).toInt(),
                (getTotal(cart)*1.1).toInt()
            )

            val payment = Payment("cash")

            val shippingAddress = ShippingAddress(
                binding.edittextCity.text.toString(),
                "",
                binding.edittextZipcode.text.toString().toInt(),
                binding.edittextAddress.text.toString(),
            "")

            var totalAmount = 0
            var itemList = ArrayList<Product>()

            for (cartProduct in cart) {
                val item = Product("", cartProduct.Price.toInt(), cartProduct.Name, cartProduct.QTY)
                totalAmount += (cartProduct.QTY * cartProduct.Price).toInt()
                itemList.add(item)
            }

            val orderData = Checkout(
                orderSummary,
                payment,
                itemList,
                shippingAddress,
                sharedPreferences.getString("user_id", "000")!!
            )

            presenter.postOrder(orderData)
        }


        updatePrice()
        binding.recyclerviewCartProduct.adapter = adapter
        return binding.root
    }

    private fun updatePrice() {
        binding.apply {
            textviewItemtotalPrice.text = getTotal(cart).toString()
            textviewTaxPrice.text = (getTotal(cart)*0.1).toString()
            textviewSubtotalPrice.text = (textviewItemtotalPrice.text.toString().toFloat() + textviewTaxPrice.text.toString().toFloat()).toString()
        }
    }

    private fun getTotal(cart: List<CartProduct>): Float {
        var itemTotal: Float = 0f

        for (cartProd in cart){
            itemTotal+=cartProd.Price*cartProd.QTY
        }

        return itemTotal
    }


    fun emptyCart() {
        val databaseHandler = createDataBaseHandler()
        databaseHandler.emptyCart()

        cart.removeAll(cart)
        adapter.notifyDataSetChanged()
        updatePrice()
        activity?.startActivity(Intent(requireActivity(), MainActivity::class.java))

    }


    private fun createDataBaseHandler(): DatabaseHandler {
        return DatabaseHandler(requireContext())
    }


}