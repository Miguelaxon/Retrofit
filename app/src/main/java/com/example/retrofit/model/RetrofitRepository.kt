package com.example.retrofit.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository(private val terraMarsDAO: TerraMarsDAO) {
    private val service = RetrofitClient.getClientRetrofit()
    val liveDataTerraMars = MutableLiveData<List<TerraMars>>()
    val listAllData: LiveData<List<TerraMars>> = terraMarsDAO.getAllTerraMars()

    suspend fun insertAllTerraMars(listTerraMars: List<TerraMars>){
        terraMarsDAO.insertAllTerraMars(listTerraMars)
    }

    suspend fun getFetchTerraMarsCoroutines() {
        Log.d("Repository", "Utilizando COROUTINES")
        try {
            val response = RetrofitClient.getClientRetrofit().getFetchTerraMarsCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    insertAllTerraMars(it)
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.d("Error Coroutina", t.message.toString())
        }
    }
}