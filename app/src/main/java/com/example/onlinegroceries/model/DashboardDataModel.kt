package com.example.onlinegroceries.model

data class DashboardDataModel(
    val `data`: List<Data>,
    val msg: String,
    val result: Boolean
) {
    data class Data(
        val cat_id: String,
        val count: Int,
        val productList: List<Product>
    ) {
        data class Product(
            val _id: String,
            val image: String,
            val name: String,
            val price: String,
            val quantity: String
        )
    }


}