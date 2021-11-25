package com.example.dbayproject.product.presenter

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.product.model.ProdData
import com.example.dbayproject.product.model.Product
import com.example.dbayproject.product.ui.ProductsFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductPresenter(val productsFragment: ProductsFragment, val context: Context): ProductContractor.Presenter {

    lateinit var prodDatas: List<ProdData>
    lateinit var queue: RequestQueue

    override fun getAllProduct(subCatId: Int) {
        val url ="https://grocery-second-app.herokuapp.com/api/products/sub/${subCatId}"

        queue = Volley.newRequestQueue(context)


        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                    response ->
                val gson = Gson()
                val typeInfo = object: TypeToken<Product>(){}
                var result: Product = gson.fromJson(response, typeInfo.type)

                if (!result.error){
                    prodDatas = result.data
                    productsFragment.setData(prodDatas)
                    Log.d("SubCatPres", "$prodDatas")
                }
            },
            {
                    error ->
                productsFragment.setEmpty()
            }
        )

        queue.add(request)
    }
}