package com.example.dbayproject.product.model

data class Product(
    val count: Int,
    val `data`: List<ProdData>,
    val error: Boolean
)

data class ProdData(
    val __v: Int,
    val _id: String,
    val catId: Int,
    val position: Int,
    val status: Boolean,
    val subDescription: String,
    val subId: Int,
    val subImage: String,
    val subName: String
)