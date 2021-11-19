package com.example.dbayproject.register.model

import android.util.Log
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.dbayproject.register.presenter.RegisterUtils
import org.json.JSONObject
import java.net.URLEncoder

class RegisterRepository {

    lateinit var queue: RequestQueue

    fun RegisterUser(name: String, mobile: String, email: String, pw: String) {

        val name = URLEncoder.encode(name, "UTF-8")
        val mobile = URLEncoder.encode(mobile, "UTF-8")
        val email = URLEncoder.encode(email, "UTF-8")
        val pw = URLEncoder.encode(pw, "UTF-8")

        queue = Volley.newRequestQueue(RegisterUtils.context)

        val requestData = "firstName=$name&email=$email&password=$pw&mobile=$mobile"

        val url = "https://grocery-second-app.herokuapp.com/api/auth/register"

        val request = object: StringRequest(
            Method.POST,
            url,
            {
                    response: String ->

                Log.d("OUTPUT", "Register: $response")
                val json = JSONObject(response)
                val status = json.getInt("status")
                val msg = json.getString("message")

                Toast.makeText(RegisterUtils.context, msg, Toast.LENGTH_SHORT).show()
            },
            {
                    error: VolleyError ->
                error.printStackTrace()
                Toast.makeText(RegisterUtils.context, "Error: $error", Toast.LENGTH_SHORT).show()
            }
        ){
//            override fun getBody(): ByteArray {
//                return requestData.toByteArray()
//            }


            override fun getHeaders(): MutableMap<String, String> {
                val valueMap = mutableMapOf<String, String>()
                valueMap.put("firstName", name)
                valueMap.put("email", email)
                valueMap.put("mobile", mobile)
                valueMap.put("password", pw)

                return valueMap
            }
        }

        queue.add(request)
    }
}