package com.example.dbayproject.subCategory.presenter

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.subCategory.model.SubCatData
import com.example.dbayproject.subCategory.model.SubCategory
import com.example.dbayproject.subCategory.ui.SubCatFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SubCatPresenter(val subCatFragment: SubCatFragment, val context: Context): SubCatContract.Presenter {

    lateinit var subCatDatas: List<SubCatData>
    lateinit var queue: RequestQueue

    override fun getSubCatData(catId: Int) {
        val url = "https://grocery-second-app.herokuapp.com/api/subcategory/${catId}"

        queue = Volley.newRequestQueue(context)

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                    response ->
                val gson = Gson()
                val typeInfo = object: TypeToken<SubCategory>(){}
                var result: SubCategory = gson.fromJson(response, typeInfo.type)

                if (!result.error){
                    subCatDatas = result.data
                    subCatFragment.setData(subCatDatas)
                    Log.d("SubCatPres", "$subCatDatas")
                }
            },
            {
                    error ->
                subCatFragment.setEmpty()
            }
        )

        queue.add(request)
    }
}