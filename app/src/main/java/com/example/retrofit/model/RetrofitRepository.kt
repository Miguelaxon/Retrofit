package com.example.retrofit.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository(private val terraMarsDAO: TerraMarsDAO) {
    private val service = RetrofitClient.getClientRetrofit()
    private val liveDataTerraMars = MutableLiveData<List<TerraMars>>()

    fun getFetchTerraMarsEnqueue(): List<TerraMars> {
        service.getFetchTerraMarsEnqueue().enqueue(object : Callback<List<TerraMars>>{
            override fun onFailure(call: Call<List<TerraMars>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<TerraMars>>,
                response: Response<List<TerraMars>>
            ) {
                TODO("Not yet implemented")
            }

        })
    }
}