package com.example.onlinegroceries.model

data class SignUpModel(
    val `data`: Data,
    val msg: String,
    val result: Boolean
) {
    data class Data(
        val __v: Int,
        val _id: String,
        val createdAt: String,
        val email: String,
        val password: String,
        val phone: String,
        val updatedAt: String
    )
}