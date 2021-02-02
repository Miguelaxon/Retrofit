package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.RetrofitRepository
import com.example.retrofit.model.TerraMars
import kotlinx.coroutines.launch

class TerraMarsViewModel: ViewModel() {
    private val repository: RetrofitRepository

    init {
        repository = RetrofitRepository()
        viewModelScope.launch {
            repository.getFetchTerraMarsCoroutines()
        }
    }

    fun getFetchTerraMars(): LiveData<List<TerraMars>>{
        return repository.getFetchTerraMarsEnqueue()
    }

    fun getFetchTerraMarsCoroutines(): LiveData<List<TerraMars>>{
        return repository.liveDataTerraMars
    }
}