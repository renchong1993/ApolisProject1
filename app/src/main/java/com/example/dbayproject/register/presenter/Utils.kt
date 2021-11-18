package com.example.dbayproject.register.presenter

import android.content.Context

class Utils {
    companion object {
        lateinit var context: Context

        fun setMyContext(mycontext: Context) {
            context = mycontext
        }
    }
}