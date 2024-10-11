package com.example.words_app.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", "99ce56a1a0msha23dcce4e8f1a70p17f625jsn0e0d7f49bc37")
            .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
            .build()

        return chain.proceed(request)
    }
}
