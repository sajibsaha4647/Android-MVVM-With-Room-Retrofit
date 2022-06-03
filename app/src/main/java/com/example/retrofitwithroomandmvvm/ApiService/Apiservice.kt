package com.example.retrofitwithroomandmvvm.ApiService

import com.example.retrofitwithroomandmvvm.Model.Quotelist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiservice {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int):Response<Quotelist>


}