package com.example.retrofit.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TerraMarsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerraMars(terraMars: TerraMars)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTerraMars(terraMars: List<TerraMars>)

    @Update
    suspend fun updateTerraMars(terraMars: TerraMars)

    @Delete
    suspend fun deleteTerraMars(terraMars: TerraMars)

    @Query("SELECT * FROM terramars_table")
    fun getAllTerraMars(): LiveData<List<TerraMars>>

    @Query("SELECT * FROM terramars_table WHERE id = :mId")
    fun getTerraMars(mId: String): LiveData<TerraMars>
}