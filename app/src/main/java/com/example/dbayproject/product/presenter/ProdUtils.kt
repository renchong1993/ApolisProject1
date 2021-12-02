package com.example.dbayproject.product.presenter

import android.content.Context

class ProdUtils{
    companion object{
        lateinit var context: Context

        fun setMyContext(myContext: Context){
            context = myContext
        }
    }
}