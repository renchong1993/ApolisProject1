package com.example.dbayproject.login.presenter

import com.example.dbayproject.login.model.LogInRepository

class LogInPresenter: LogInContract.Presenter{
    override fun onButtonClick(email: String, pw: String) {
        val loginRepository = LogInRepository()

        loginRepository.Login(email, pw)
    }

}