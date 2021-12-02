package com.example.dbayproject.orders.presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.MainActivity
import com.example.dbayproject.orders.model.Checkout
import com.example.dbayproject.shoppingcart.ui.CartFragment
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.json.JSONObject

class OrderPresenter(val cartFragment: CartFragment, val context: Context): OrderContract.Presenter {

    lateinit var requestQueue: RequestQueue

    override fun postOrder(orderData: Checkout) {

        val url = "https://grocery-second-app.herokuapp.com/api/orders"
        val mapper = jacksonObjectMapper()
        val params = JSONObject(mapper.writeValueAsString(orderData))

        Log.d("param", "$params")

        requestQueue = Volley.newRequestQueue(context)

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            params,
            {response: JSONObject ->
                val msg = response.getString("message")
                Log.d("Order", "$msg")
                Toast.makeText(context, "Order has been placed successfully! Thank you for your business!", Toast.LENGTH_LONG).show()
                cartFragment.emptyCart()
            },
            { error ->
//                Toast.makeText(context, "Error: $error", Toast.LENGTH_SHORT).show()
                Log.d("Order", "$error")
            }
        )
        requestQueue.add(request)


    }
}