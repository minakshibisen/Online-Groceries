package com.example.onlinegroceries.model

data class LoginModel(
    val `data`: Data,
    val msg: String,
    val result: Boolean
) {
    data class Data(
        val __v: Int,
        val _id: String,
        val createdAt: String,
        val email: String,
        val phone: String,
        val updatedAt: String
    )
}