package com.example.dbayproject.register.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dbayproject.MainActivity
import com.example.dbayproject.databinding.ActivityRegisterBinding
import com.example.dbayproject.login.ui.LoginActivity
import com.example.dbayproject.register.presenter.RegisterContract
import com.example.dbayproject.register.presenter.RegisterInteractor
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

        presenter = RegisterPresenter(this, RegisterInteractor())

        binding.apply {

            progressBar.visibility = View.GONE
            textviewErrorMSG.visibility = View.GONE

            buttonSignup.setOnClickListener {
                val name = edittextFirstname.text.toString()
                val mobile = edittextMobile.text.toString()
                val email = edittextEmail.text.toString()
                val pw = edittextPassword.text.toString()

                presenter.onButtonClick(name,mobile,email,pw)
            }

            textviewRegiSignin.setOnClickListener {
                    startActivity(Intent(RegisterUtils.context, LoginActivity::class.java))
                }
            }
    }



    override fun toSignInPage() {
        startActivity(Intent(this, LoginActivity::class.java))
    }


    override fun showError(error: String) {
        binding.textviewErrorMSG.visibility = View.VISIBLE
        binding.textviewErrorMSG.text = error
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