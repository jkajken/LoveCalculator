package com.jk.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jk.lovecalculator.remote.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insertLove(model: LoveModel)

    @Query("SELECT * FROM lovemodel")
    fun getAll(): LiveData <List<LoveModel>>

    @Query("SELECT * FROM lovemodel ORDER BY firstName ASC")
    fun getAllByAlphabet(): List<LoveModel>

}