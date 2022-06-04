package com.example.retrofitwithroomandmvvm.Repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.Model.Quotelist
import com.example.retrofitwithroomandmvvm.Room.Databse.DatabaseSet
import com.example.retrofitwithroomandmvvm.Utils.NetworkUtils
import java.lang.Exception

class Repositorys(
    private val apiservice: Apiservice,
    private val databaseSet: DatabaseSet,
    private val applicationContext: Context
) {

    private val allQuotelist = MutableLiveData<Response<Quotelist>>()
    val Quotes: LiveData<Response<Quotelist>> get() = allQuotelist


    suspend fun getQuotes(page: Int) { //store value from api
        var netwoeks:Boolean = NetworkUtils.isInternetAvaileable(applicationContext)
        Log.d("callingfrom activity",netwoeks.toString())
        if (NetworkUtils.isInternetAvaileable(applicationContext)) {
            Log.d("calling","calling")
           try {
               val result = apiservice.getQuotes(page)

               if (result?.body() != null) {
                   databaseSet.QuoteDaoList().insertQuotes(result.body()!!.results)
                   allQuotelist.postValue(Response.Success(result.body()))
               }else{
                   allQuotelist.postValue(Response.Error("Api error"))
               }
           }catch (e:Exception){
               allQuotelist.postValue(Response.Error(e.message.toString()))
               Log.d("Exception1","Exception1")
           }
        } else {
            try {
                val quotes = databaseSet.QuoteDaoList().getAllQuotes()
                val quotelist = Quotelist(1, 1, 1, quotes, 1, 1);
                allQuotelist.postValue(Response.Success(quotelist))
            }catch (e:Exception){
                allQuotelist.postValue(Response.Error(e.message.toString()))
                Log.d("Exception2","Exception2")
            }
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