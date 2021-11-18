package com.example.dbayproject.register.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ActivityRegisterBinding
import com.example.dbayproject.register.presenter.Contract
import com.example.dbayproject.register.presenter.RegisterPresenter
import com.example.dbayproject.register.presenter.Utils

class RegisterActivity : AppCompatActivity(), Contract.View {

    lateinit var binding: ActivityRegisterBinding
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        Utils.setMyContext(this)

        presenter = RegisterPresenter()

        binding.apply {
            val name = edittextFirstname.text.toString()
            val mobile = edittextMobile.text.toString()
            val email = edittextEmail.text.toString()
            val pw = edittextPassword.text.toString()
            buttonSignup.setOnClickListener {
                presenter.onButtenClick(name,mobile,email,pw)
            }
        }

    }

    override fun ShowError(error: String) {
        TODO("Not yet implemented")
    }
}