//package com.example.dbayproject.register.model
//
//import android.util.Log
//import android.widget.Toast
//import com.android.volley.Request
//import com.android.volley.RequestQueue
//import com.android.volley.VolleyError
//import com.android.volley.toolbox.JsonObjectRequest
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.example.dbayproject.register.presenter.RegisterUtils
//import org.json.JSONObject
//import java.net.URLEncoder
//
//class RegisterRepository {
//
//    lateinit var queue: RequestQueue
//
//    fun RegisterUser(name: String, mobile: String, email: String, pw: String) {
//
//
//        val params = JSONObject()
//        params.put("email", email)
//        params.put("password", pw)
//        params.put("firstName", name)
//        params.put("mobile", mobile)
//
//        queue = Volley.newRequestQueue(RegisterUtils.context)
//
//
//        val url = "https://grocery-second-app.herokuapp.com/api/auth/register"
//
//        val request = JsonObjectRequest(
//            Request.Method.POST,
//            url,
//            params,
//            { response ->
//
//                val error = response.getBoolean("error")
//                val msg = response.getString("message")
//
//                if(error){
//                    Toast.makeText(RegisterUtils.context, msg, Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(RegisterUtils.context, "Success", Toast.LENGTH_SHORT).show()
//
//                }
//            },
//            { error: VolleyError ->
//                error.printStackTrace()
//                Toast.makeText(RegisterUtils.context, "Error: $error", Toast.LENGTH_SHORT).show()
//            }
//        )
//
//        queue.add(request)
//    }
//}