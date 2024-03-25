package com.example.tendayschallenge.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {
    companion object {
        private const val BASE_URL = "https://api.nasa.gov/"
        private val retrofitBuilder: Retrofit.Builder =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofit:Retrofit = retrofitBuilder.build()
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}