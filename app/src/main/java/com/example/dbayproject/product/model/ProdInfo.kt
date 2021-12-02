package com.example.dbayproject.product.model

data class ProdInfo(
    val count: Int,
    val `data`: List<ProdData>,
    val error: Boolean
)


data class ProdData(
    val __v: Int,
    val _id: String,
    val catId: Int,
    val created: String,
    val description: String,
    val image: String,
    val mrp: Int,
    val position: Int,
    val price: Int,
    val productName: String,
    val quantity: Int,
    val status: Boolean,
    val subId: Int,
    val unit: String
)