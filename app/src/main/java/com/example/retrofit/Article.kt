package com.example.retrofit

data class Article(
    val id: String,
    val title: String,
    val body: String,
    val created_at: String,
    val updated_at: String,
    val user: User
)

data class User(
    val id: String,
    val name: String,
    val profile_image_url: String
)
