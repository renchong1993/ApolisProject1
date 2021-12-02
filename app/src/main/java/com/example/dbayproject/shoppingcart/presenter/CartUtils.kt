package com.example.dbayproject.shoppingcart.presenter

import android.content.Context

class CartUtils {

    companion object {
        lateinit var context: Context

        fun setMyContext(myContext: Context) {
            context = myContext
        }
    }
}