package com.example.dbayproject.register.presenter

import com.example.dbayproject.register.model.RegisterRepository

class RegisterPresenter: RegisterContract.Presenter {

    override fun onButtenClick(name: String, mobile: String, email:String, pw:String) {
        val registerRepository = RegisterRepository()

        registerRepository.RegisterUser(name, mobile, email, pw)
    }
}