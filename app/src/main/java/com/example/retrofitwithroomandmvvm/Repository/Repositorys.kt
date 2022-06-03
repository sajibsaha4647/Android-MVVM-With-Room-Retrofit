package com.example.retrofitwithroomandmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.Model.Quotelist

class Repositorys(private val apiservice: Apiservice) {

    private val allQuotelist = MutableLiveData<Quotelist>()
    val Quotes : LiveData<Quotelist>get() = allQuotelist

    suspend fun getQuotes(page:Int){ //store value from api
        val result = apiservice.getQuotes(page)
        if(result?.body() != null){
            allQuotelist.postValue(result.body())
        }
    }

}