package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET


interface QiitaService {
    @GET("items")
    fun fetchData(): Call<List<Article>>
}

public const val BASE_URL = "https://qiita.com/api/v2/"