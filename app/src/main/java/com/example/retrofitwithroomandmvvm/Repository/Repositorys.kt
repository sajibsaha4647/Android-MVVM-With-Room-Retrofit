package com.example.retrofitwithroomandmvvm.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.Model.Quotelist
import com.example.retrofitwithroomandmvvm.Room.Databse.DatabaseSet
import com.example.retrofitwithroomandmvvm.Utils.NetworkUtils

class Repositorys(
    private val apiservice: Apiservice,
    private val databaseSet: DatabaseSet,
    private val applicationContext: Context
) {

    private val allQuotelist = MutableLiveData<Quotelist>()
    val Quotes: LiveData<Quotelist> get() = allQuotelist


    suspend fun getQuotes(page: Int) { //store value from api

        if (NetworkUtils.isInternetAvaileable(applicationContext)) {
            val result = apiservice.getQuotes(page)
            if (result?.body() != null) {
                databaseSet.QuoteDaoList().insertQuotes(result.body()!!.results)
                allQuotelist.postValue(result.body())
            }
        } else {
            val quotes = databaseSet.QuoteDaoList().getAllQuotes()
            val quotelist = Quotelist(1, 1, 1, quotes, 1, 1);
            allQuotelist.postValue(quotelist)
        }


    }

    suspend fun getQuotesackground(){
        val randNUmber = (Math.random() * 10).toInt()
        val result = apiservice.getQuotes(randNUmber)
        if(result?.body() !=  null){
            databaseSet.QuoteDaoList().insertQuotes(result.body()!!.results)
        }
    }

}