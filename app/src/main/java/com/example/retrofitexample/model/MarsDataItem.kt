package com.example.retrofitexample.model


import com.squareup.moshi.Json

data class MarsDataItem(
    val id: String,
    @Json(name = "img_src") val imgSrc: String,
    val price: Int,
    val type: String
)