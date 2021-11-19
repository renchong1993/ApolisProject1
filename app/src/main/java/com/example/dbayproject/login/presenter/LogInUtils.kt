package com.example.dbayproject.login.presenter

import android.content.Context

class LogInUtils {
    companion object {
        lateinit var context: Context

        fun setMyContext(mycontext: Context) {
            context = mycontext
        }
    }
}