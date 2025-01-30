package com.silaeva.coursefinder.data.retrofite_client

import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val interceptor = HttpLoggingInterceptor()

    init {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://stepik.org/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val coursesApi: CoursesApi by lazy {
        retrofit.create(CoursesApi::class.java)
    }
}