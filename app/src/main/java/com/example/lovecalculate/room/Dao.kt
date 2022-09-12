package com.example.lovecalculate.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.lovecalculate.network.model.LoveModel

@Dao
interface Dao {
    @Query("SELECT * FROM loveModel ORDER BY firstName ASC")
    fun sort():LiveData<List<LoveModel>>
}