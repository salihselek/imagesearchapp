package com.example.imagesearchapp.api

import com.example.imagesearchapp.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>,
    val result2: String = "",
    val result3:String = ""
)