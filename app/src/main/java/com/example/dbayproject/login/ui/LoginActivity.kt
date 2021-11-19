package com.example.dbayproject.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dbayproject.MainActivity
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ActivityLoginBinding
import com.example.dbayproject.login.presenter.LogInPresenter
import com.example.dbayproject.login.presenter.LogInUtils
import com.example.dbayproject.register.ui.RegisterActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LogInPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        LogInUtils.setMyContext(this)

        presenter = LogInPresenter()

        binding.apply {
            val email = edittextEmail.text.toString()
            val pw = edittextPassword.text.toString()

            buttonLogin.setOnClickListener {
//                presenter.onButtonClick(email,pw)
                startActivity(Intent(LogInUtils.context, MainActivity::class.java))
            }

            buttonRegister.setOnClickListener {
                startActivity(Intent(LogInUtils.context, RegisterActivity::class.java))
            }
        }
    }
}