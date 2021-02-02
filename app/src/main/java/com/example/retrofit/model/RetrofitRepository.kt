package com.example.retrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository() {
    private val service = RetrofitClient.getClientRetrofit()
    val liveDataTerraMars = MutableLiveData<List<TerraMars>>()

    fun getFetchTerraMarsEnqueue(): LiveData<List<TerraMars>> {
        service.getFetchTerraMarsEnqueue().enqueue(object : Callback<List<TerraMars>>{
            override fun onFailure(call: Call<List<TerraMars>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<TerraMars>>,
                response: Response<List<TerraMars>>
            ) {
                when(response.code()){
                    in 200..299 -> liveDataTerraMars.value = response.body()
                    in 300..399 -> Log.d("ERROR", response.message().toString())
                    else -> Log.d("ERROR", "Error del servidor ${response.code()}")
                }
            }
        })
        return liveDataTerraMars
    }

    suspend fun getFetchTerraMarsCoroutines() {
        Log.d("Repository", "Utilizando COROUTINES")
        try {
            val response = RetrofitClient.getClientRetrofit().getFetchTerraMarsCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataTerraMars.value = it
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.d("Error Coroutina", t.message.toString())
        }
    }
}