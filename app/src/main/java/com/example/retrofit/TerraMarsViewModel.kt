package com.example.retrofit

import android.app.Application
import androidx.lifecycle.*
import com.example.retrofit.model.RetrofitDB
import com.example.retrofit.model.RetrofitRepository
import com.example.retrofit.model.TerraMars
import kotlinx.coroutines.launch

class TerraMarsViewModel(appication: Application): AndroidViewModel(appication) {
    private val repository: RetrofitRepository
    val allData: LiveData<List<TerraMars>>
    val selectedTerraMars: MutableLiveData<TerraMars> = MutableLiveData()

    init {
        val terraMars = RetrofitDB.getDataBase(appication).getTerraMarsDao()
        repository = RetrofitRepository(terraMars)
        viewModelScope.launch {
            repository.getFetchTerraMarsCoroutines()
        }
        allData = repository.listAllData
    }
    //se podría usar para refrescar la vista
    fun getFetchTerraMarsCoroutines(): LiveData<List<TerraMars>>{
        return repository.liveDataTerraMars
    }

    fun selected(terraMars: TerraMars?) {
        selectedTerraMars.value = terraMars
    }
}