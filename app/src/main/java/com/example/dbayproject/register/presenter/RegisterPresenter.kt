package com.example.dbayproject.register.presenter

import com.example.dbayproject.register.ui.RegisterActivity

class RegisterPresenter(var registerActivity: RegisterActivity?, var registerInteractor: RegisterInteractor): RegisterInteractor.onRegisterFinishListener {

    fun onButtonClick(name: String, mobile: String, email:String, pw:String) {
        registerActivity?.showProgress()
        register(name, mobile, email, pw)
    }

    fun register(name: String, mobile: String, email:String, pw:String){
        registerInteractor.registerUser(name, mobile, email, pw,this)
    }

    override fun onSuccess() {
        registerActivity?.hideProgress()
        registerActivity?.toSignInPage()
    }

    override fun onError() {
        registerActivity?.hideProgress()
    }

    fun onDestroy() {
        registerActivity = null
    }
}