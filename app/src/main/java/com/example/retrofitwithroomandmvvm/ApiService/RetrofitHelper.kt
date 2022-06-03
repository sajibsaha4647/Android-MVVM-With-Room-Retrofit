package com.example.retrofitwithroomandmvvm.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val BASE_URL = "https://www.quotable.io"
    fun instance():Retrofit{
        return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }


}