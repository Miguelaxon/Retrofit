package com.example.retrofit.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface IApi {
    @GET("realestate")
    suspend fun getFetchTerraMarsCoroutines(): Response<List<TerraMars>>
}