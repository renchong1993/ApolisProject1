package com.example.dbayproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ActionMode
import android.view.animation.AnimationUtils
import androidx.activity.result.contract.ActivityResultContracts
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

            }
        }

        val handler: Handler = Handler()
        val run = object : Runnable {
            override fun run() {
                Intent(this@SplashActivity, RegisterActivity::class.java)
                handler.postDelayed(this, 4000)// 4 seconds
            }

        }
        handler.post(run)
    }

//        Handler().postDelayed(toNext(), 3000)

//        startActivity(Intent(baseContext, RegisterActivity::class.java))



}