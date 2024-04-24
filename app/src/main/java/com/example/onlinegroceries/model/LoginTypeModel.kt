package com.example.onlinegroceries.model

data class LoginTypeModel(
    val `data`: Data,
    val msg: String,
    val result: Boolean
) {
    data class Data(
        val _id: String,
        val facebook_enabled: Boolean,
        val google_enabled: Boolean,
        val location: String,
        val method: String
    )
}