package com.example.dbayproject.register.presenter

import com.example.dbayproject.register.model.RegisterRepository
import com.example.dbayproject.register.ui.RegisterActivity

interface RegisterContract {
    interface View{
        fun ShowError(error:String)
    }

    interface Presenter{

        fun onButtonClick(name: String, mobile: String, email:String, pw:String)
    }


}