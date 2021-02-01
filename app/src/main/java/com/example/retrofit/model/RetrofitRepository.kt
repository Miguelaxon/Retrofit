package com.example.retrofit.model

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.net.CacheResponse
import javax.security.auth.callback.Callback

class RetrofitRepository(private val terraMarsDAO: TerraMarsDAO) {
    private var service = RetrofitClient.getClientRetrofit()
    var mLiveData = terraMarsDAO.getAllTerraMars()

    fun getData(){
        val call = service.getDataFromApi()
        call.enqueue(object : Callback<List<TerraMars>>{
            override fun OnResponse(call: Call<List<TerraMars>>, response: Response<List<TerraMars>>){
                when(response.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            terraMarsDAO.insertAllTerraMars(it)
                        }
                    }
                    in 300..399 -> Log.d("Error 300", response.errorBody().toString())
                }
            }
            override fun onFailure(call: Call<List<TerraMars>>, t: Throwable){
                Log.e("RetrofitRepository", t.message.toString())
            }
        })
    }
}