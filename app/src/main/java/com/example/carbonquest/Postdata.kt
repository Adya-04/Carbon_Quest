package com.example.carbonquest

data class Postdata(
        val author: String,
        val content: String,
        val imageUrl: String? = null,
        val name: String,
        var isLiked: Boolean = false
    )
