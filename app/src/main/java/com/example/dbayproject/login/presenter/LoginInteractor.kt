package com.example.dbayproject.login.presenter

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.login.model.UserX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class LoginInteractor {

    lateinit var queue: RequestQueue

    interface onLoginFinishListener {
       fun onError()
       fun onSuccess()
    }

    fun loginUser(email: String, pw: String, listener: onLoginFinishListener) {

        queue = Volley.newRequestQueue(LogInUtils.context)

        val sharedPreferences: SharedPreferences = LogInUtils.context.getSharedPreferences("LoginSP", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        val params = JSONObject()
        params.put("email", email)
        params.put("password", pw)

        Log.d("Login", params.toString())
        val url = "https://grocery-second-app.herokuapp.com/api/auth/login"

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            params,
            {
                val typeToken = object: TypeToken<UserX>(){}
                val gson = Gson()
                val user = gson.fromJson<UserX>(it.toString(), typeToken.type)


                editor.putString("mobile", user.mobile)
                editor.putString("user_id", user._id)
                editor.putString("firstName", user.firstName)
                editor.putString("email", user.email)
                editor.putBoolean("is_loggedIn", true)
                editor.apply()

                Toast.makeText(LogInUtils.context, "Success", Toast.LENGTH_SHORT).show()
                listener.onSuccess()

            } ,
            {
                    error ->

                Toast.makeText(LogInUtils.context, "Failed to login: ${error}", Toast.LENGTH_SHORT).show()
                listener.onError()
            },
        )
        queue.add(request)

    }
}