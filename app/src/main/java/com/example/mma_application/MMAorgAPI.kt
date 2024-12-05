package com.example.mma_application

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MMAorgAPI {
    private const val BASE_URL = "https://mmaapi.p.rapidapi.com/api/mma/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .addHeader("x-rapidapi-key", "4e92f36cdfmsh5a7904d17b5cb9dp18ee4ejsnaa0938e9585d")
                .addHeader("x-rapidapi-host", "mmaapi.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: OrganizationAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrganizationAPI::class.java)
    }
}