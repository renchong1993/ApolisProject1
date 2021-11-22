package com.example.dbayproject.register.presenter


import com.example.dbayproject.register.ui.RegisterActivity

interface RegisterContract {
    interface View{
        fun showProgress()
        fun hideProgress()
        fun showError(error:String)
        fun toSignInPage()
    }

    interface Presenter{
        fun onButtonClick(name: String, mobile: String, email:String, pw:String)
    }


}