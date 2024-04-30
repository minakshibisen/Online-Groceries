package com.example.onlinegroceries.model

data class BannerModel(
    val `data`: List<Data>,
    val msg: String,
    val result: Boolean
) {
    data class Data(
        val _id: String,
        val imageUrl: String,
        val isActive: Boolean,
        val offerId: String,
        val validFrom: String,
        val validTill: String
    )
}