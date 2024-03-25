package com.example.tendayschallenge.data

import com.example.tendayschallenge.data.model.NasaResource
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    companion object {
        private const val API_KEY: String = "MOtGbMeYiibPuxLnAQJbANnBYQtmhk9197mE5RY5"
    }

    @GET("planetary/apod")
    suspend fun getImageList(
        @Query("start_date") startDate: String?,
        @Query("end_date") endDate: String?,
        @Query("api_key") apiKey: String = API_KEY
    ): List<NasaResource>

    @GET("planetary/apod")
    suspend fun getTodayImage(
        @Query("api_key") apiKey: String = API_KEY
    ): NasaResource
}
