package com.example.retrofit.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    companion object{
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"
        fun getClientRetrofit(): IApi{
            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetrofit.create(IApi::class.java)
        }
    }
}