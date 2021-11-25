package com.example.dbayproject.mainCategory.presenter

import com.example.dbayproject.mainCategory.model.CatData

interface MainCatContractor {
    interface View {
        fun setData(catDatas: List<CatData>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(boolean: Boolean)
    }

    interface Presenter {
        fun getAllCatData()
    }
}