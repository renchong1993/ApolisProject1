package com.example.dbayproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ActionMode
import android.view.animation.AnimationUtils
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dbayproject.databinding.ActivitySplashBinding
import com.example.dbayproject.login.ui.LoginActivity
import com.example.dbayproject.register.ui.RegisterActivity

class SplashActivity : AppCompatActivity() {


    lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_out)

        binding.apply {
            textviewDemo.startAnimation(animation)


            textviewDemo.setOnClickListener {

            }
        }

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, LoginActivity::class.java))

            // close this activity
            finish()
        }, 3000)

    }

}