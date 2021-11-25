package com.example.dbayproject.subCategory.presenter

import com.example.dbayproject.mainCategory.model.CatData
import com.example.dbayproject.subCategory.model.SubCatData

interface SubCatContract {

    interface View {
        fun setData(catDatas: List<SubCatData>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(boolean: Boolean)
    }

    interface Presenter {
        fun getSubCatData(catId: Int)
    }
}