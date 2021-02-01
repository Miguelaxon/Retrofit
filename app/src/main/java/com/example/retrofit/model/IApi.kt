package com.example.retrofit.model

import retrofit2.Call
import retrofit2.http.GET

interface IApi {
    @GET("realestate")
    fun getDataFromApi(): Call<List<TerraMars>>
}