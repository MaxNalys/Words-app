package com.example.words_app.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor())
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://wordsapiv1.p.rapidapi.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: WordApi by lazy {
        retrofit.create(WordApi::class.java)
    }
}
