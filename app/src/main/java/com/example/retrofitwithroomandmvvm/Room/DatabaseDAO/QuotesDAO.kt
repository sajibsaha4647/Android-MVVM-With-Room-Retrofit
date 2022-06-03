package com.example.retrofitwithroomandmvvm.Room.Database.DatabaseSAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitwithroomandmvvm.Model.Result
import com.example.retrofitwithroomandmvvm.Room.Database.DatabaseModel.QuoteModel

@Dao
interface QuotesDAO {

    @Insert
    suspend fun insertQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quotemodel")
    fun getAllQuotes():List<Result>
}