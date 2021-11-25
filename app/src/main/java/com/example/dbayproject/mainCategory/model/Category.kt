package com.example.dbayproject.mainCategory.model

data class Category(
    val count: Int,
    val `data`: List<CatData>,
    val error: Boolean
)

data class CatData(
    val __v: Int,
    val _id: String,
    val catDescription: String,
    val catId: Int,
    val catImage: String,
    val catName: String,
    val position: Int,
    val slug: String,
    val status: Boolean
)