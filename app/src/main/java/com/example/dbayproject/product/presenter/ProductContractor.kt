package com.example.dbayproject.product.presenter

import com.example.dbayproject.product.model.ProdData

interface ProductContractor {
    interface View {
        fun setData(prodDatas: List<ProdData>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(boolean: Boolean)
    }

    interface Presenter {
        fun getAllProduct(subCatId: Int)
    }
}