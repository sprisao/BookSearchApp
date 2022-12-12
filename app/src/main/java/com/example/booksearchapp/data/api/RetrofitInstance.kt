package com.example.booksearchapp.data.api

import com.example.booksearchapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val okHttpClient: OkHttpClient by lazy {

        /* http 통신간 이루어지는 bodylevel의 log들을 가로챈다. */
        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        /* Intercepter를 포함하여 OkHttpClient를 빌드한다. */
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    /* 위에서 빌드된 OkhttpClient를 통해 Retrofit을 빌드한다. */

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(BASE_URL)
            .client(okHttpClient).build()
    }

    val api: BookSearchApi by lazy {

        /* BookSearchApi를 통한 Http통신을 생성한다. */
        retrofit.create(BookSearchApi::class.java)
    }
}
