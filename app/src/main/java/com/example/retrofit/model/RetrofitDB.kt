package com.example.retrofit.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TerraMars::class], version = 1)
abstract class RetrofitDB : RoomDatabase() {
    abstract fun getTerraMarsDao(): TerraMarsDAO
    companion object {
        @Volatile
        private var INSTANCE: RetrofitDB? = null
        fun getDataBase(context: Context): RetrofitDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                        RetrofitDB::class.java, "terraMarsDB")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}