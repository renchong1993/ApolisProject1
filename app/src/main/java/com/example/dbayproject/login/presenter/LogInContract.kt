package com.example.dbayproject.login.presenter

import com.example.dbayproject.register.model.RegisterRepository
import com.example.dbayproject.register.ui.RegisterActivity

interface LogInContract {
    interface View{
        fun ShowError(error:String)
    }

    interface Presenter{
        fun onButtonClick(email:String, pw:String)
    }

}