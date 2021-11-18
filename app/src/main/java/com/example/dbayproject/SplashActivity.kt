package com.example.dbayproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.dbayproject.databinding.ActivitySplashBinding
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


            textviewDemo.setOnClickListener{
                val intent = Intent(this@SplashActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

    }
}