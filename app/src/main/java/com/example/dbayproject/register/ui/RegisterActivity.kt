package com.example.dbayproject.register.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dbayproject.databinding.ActivityRegisterBinding
import com.example.dbayproject.login.ui.LoginActivity
import com.example.dbayproject.register.presenter.RegisterContract
import com.example.dbayproject.register.presenter.RegisterPresenter
import com.example.dbayproject.register.presenter.RegisterUtils


class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    lateinit var binding: ActivityRegisterBinding
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        RegisterUtils.setMyContext(this)

        presenter = RegisterPresenter()

        binding.apply {
            val name = edittextFirstname.text.toString()
            val mobile = edittextMobile.text.toString()
            val email = edittextEmail.text.toString()
            val pw = edittextPassword.text.toString()

            buttonSignup.setOnClickListener {
                presenter.onButtonClick(name,mobile,email,pw)
            }

            textviewRegiSignin.setOnClickListener {
                    startActivity(Intent(RegisterUtils.context, LoginActivity::class.java))
                }
            }
    }



    override fun ShowError(error: String) {
        TODO("Not yet implemented")
    }
}