package com.example.dbayproject.login.presenter


import com.example.dbayproject.register.ui.RegisterActivity

interface LogInContract {
    interface View{
        fun showProgress()
        fun hideProgress()
        fun showError()
        fun toMainPage()
    }

    interface Presenter{
        fun onButtonClick(email:String, pw:String)

    }

}