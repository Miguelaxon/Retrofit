package com.example.retrofit.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "terramars_table")
data class TerraMars (@PrimaryKey(autoGenerate = false) @NonNull var id: String,
                      var type: String,
                      var price: Long,
                      @SerializedName("img_src")
                      var imgSrc: String)