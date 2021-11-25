package com.example.dbayproject.mainCategory.presenter

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.mainCategory.model.Category
import com.example.dbayproject.mainCategory.ui.CategoryFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken as TypeToken

class CatPresenter(val categoryFragment: CategoryFragment, val context: Context): MainCatContractor.Presenter {

    lateinit var catDatas: List<CatData>
    lateinit var queue: RequestQueue

    override fun getAllCatData() {

        val url="https://grocery-second-app.herokuapp.com/api/category"

        queue = Volley.newRequestQueue(context)

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                response ->
                val gson = Gson()
                val typeInfo = object: TypeToken<Category>(){}
                var result: Category = gson.fromJson(response, typeInfo.type)

                if (!result.error){
                    catDatas = result.data
                    categoryFragment.setData(catDatas)
                    Log.d("CatPres", "$catDatas")
                }
            },
            {
                error ->
                categoryFragment.setEmpty()
            }
        )

        queue.add(request)
    }


}