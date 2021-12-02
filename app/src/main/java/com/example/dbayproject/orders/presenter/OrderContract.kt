package com.example.dbayproject.orders.presenter

import com.example.dbayproject.orders.model.Checkout
import com.example.dbayproject.subCategory.model.SubCatData

interface OrderContract {

    interface View {
        fun setData()
    }

    interface Presenter {
        fun postOrder(orderData: Checkout)
    }

}