package com.example.words_app.data.remote

import com.example.words_app.data.model.WordResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WordApi {
    @GET("words/{word}/synonyms")
    suspend fun getSynonyms(@Path("word") word: String): WordResponse

    @GET("words/{word}/antonyms")
    suspend fun getAntonyms(@Path("word") word: String): WordResponse

    @GET("words/{word}/definitions")
    suspend fun getDefinitions(@Path("word") word: String): WordResponse

    @GET("words/{word}/rhymes")
    suspend fun getRhymes(@Path("word") word: String): WordResponse

    @GET("words/{word}/examples")
    suspend fun getExamples(@Path("word") word: String): WordResponse
}
