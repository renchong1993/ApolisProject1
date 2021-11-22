package com.example.dbayproject.login.presenter


import com.example.dbayproject.login.ui.LoginActivity

class LogInPresenter(var loginActivity: LoginActivity?, var loginInteractor: LoginInteractor): LoginInteractor.onLoginFinishListener{
    fun onButtonClick(email: String, pw: String) {
        loginActivity?.showProgress()
        login(email, pw)
    }

    fun login(email: String, pw: String){
        loginInteractor.loginUser(email, pw,this)
    }

    override fun onSuccess() {
        loginActivity?.hideProgress()
        loginActivity?.toMainPage()
    }

    override fun onError() {
        loginActivity?.hideProgress()
        loginActivity?.showError()
    }

    fun onDestroy() {
        loginActivity = null
    }

}