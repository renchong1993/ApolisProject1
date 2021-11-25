package com.example.dbayproject.login.model

data class User(
    val token: String,
    val user: UserX
)

data class UserX(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val firstName: String,
    val mobile: String,
    val password: String
)