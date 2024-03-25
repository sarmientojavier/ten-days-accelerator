package com.example.tendayschallenge.data.model

import com.google.gson.annotations.SerializedName

data class NasaResource (
    @SerializedName("title")
    val title: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("explanation")
    val explanation: String?,
    @SerializedName("hdurl")
    val hdUrl: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("service_version")
    val serviceVersion: String?
)