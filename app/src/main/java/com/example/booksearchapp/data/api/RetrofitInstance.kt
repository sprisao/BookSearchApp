package com.example.booksearchapp.data.api

import com.example.booksearchapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(BASE_URL)
            .client(okHttpClient).build()
    }

    val api: BookSearchApi by lazy {
        retrofit.create(BookSearchApi::class.java)
    }
}
