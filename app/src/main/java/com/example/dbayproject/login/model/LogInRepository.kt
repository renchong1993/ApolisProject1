package com.example.dbayproject.login.model

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.MainActivity
import com.example.dbayproject.login.presenter.LogInUtils
import org.json.JSONObject
import java.net.URLEncoder

class LogInRepository {
    lateinit var queue: RequestQueue

    fun Login(email: String, pw: String) {

        val email = URLEncoder.encode(email, "UTF-8")
        val pw = URLEncoder.encode(pw, "UTF-8")

        queue = Volley.newRequestQueue(LogInUtils.context)

        val requestData = "email=$email&password=$pw"

        val url = "https://grocery-second-app.herokuapp.com/api/auth/login"

        val request = object: StringRequest(
            Method.POST,
            url,
            {
                    response: String ->
                val json = JSONObject(response)
                val status = json.getInt("status")
                val msg = json.getString("message")

                if (status == 0) {

//                    val sharedPreferences: SharedPreferences = this.getSharedPreferences(
//                        "LoginSP",
//                        Context.MODE_PRIVATE)
//                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//                    val user = JSONObject(json.getString("user"))
//                    editor.putString("mobile", user.getString("mobile"))
//                    editor.putString("user_id", user.getString("_id"))
//                    editor.putString("firstName", user.getString("firstName"))
//                    editor.putString("email", user.getString("email"))
//                    editor.putBoolean("is_admin", user.getString("is_admin").toBoolean())
//                    editor.putBoolean("is_loggedIn", true)
//                    editor.apply()
//
//                    startActivity(Intent(LogInUtils.context, MainActivity::class.java))

                    Toast.makeText(LogInUtils.context, msg, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(LogInUtils.context, "Failed to login: $msg", Toast.LENGTH_SHORT).show()
                }
            },
            { error: VolleyError ->
                Toast.makeText(LogInUtils.context, "Error occurred: ${error.toString()}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getBody(): ByteArray {
                return requestData.toByteArray()
            }
        }
        queue.add(request)
    }
}