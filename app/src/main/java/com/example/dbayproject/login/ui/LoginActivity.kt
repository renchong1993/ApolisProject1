package com.example.dbayproject.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dbayproject.MainActivity
import com.example.dbayproject.R
import com.example.dbayproject.databinding.ActivityLoginBinding
import com.example.dbayproject.login.presenter.LogInContract
import com.example.dbayproject.login.presenter.LogInPresenter
import com.example.dbayproject.login.presenter.LogInUtils
import com.example.dbayproject.login.presenter.LoginInteractor
import com.example.dbayproject.register.ui.RegisterActivity

class LoginActivity : AppCompatActivity(), LogInContract.View {

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LogInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LogInUtils.setMyContext(this)

        presenter = LogInPresenter(this, LoginInteractor())

        binding.apply {

            progressBar.visibility = View.GONE
            textviewErrorMSG.visibility = View.GONE

            buttonLogin.setOnClickListener {
                val email = edittextEmail.text.toString()
                val pw = edittextPassword.text.toString()

                presenter.onButtonClick(email,pw)
            }

            buttonRegister.setOnClickListener {
                startActivity(Intent(LogInUtils.context, RegisterActivity::class.java))
            }
        }
    }




    override fun toMainPage() {
        startActivity(Intent(this, MainActivity::class.java))
    }


    override fun showError() {
        binding.textviewErrorMSG.visibility = View.VISIBLE
        binding.textviewErrorMSG.text = "Error. Credential error, please retry"
    }


    override fun showProgress(){
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress(){
        binding.progressBar.visibility = View.GONE

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}