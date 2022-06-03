package com.example.retrofitwithroomandmvvm.Room.Databse

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitwithroomandmvvm.Room.Database.DatabaseModel.QuoteModel
import com.example.retrofitwithroomandmvvm.Room.Database.DatabaseSAO.QuotesDAO

@Database(entities = [QuoteModel::class], version = 1)
abstract class DatabaseSet:RoomDatabase() {

    abstract fun QuoteDaoList():QuotesDAO

    companion object{
        @Volatile
        private  var INSTANCE : DatabaseSet? = null

        fun  getDatabaseInstance(context: Context):DatabaseSet{
            if(INSTANCE == null){
              synchronized(this){
                  INSTANCE = Room.databaseBuilder(context,DatabaseSet::class.java,"quotedata.db").build()
              }

            }
            return INSTANCE!!
        }
    }

}