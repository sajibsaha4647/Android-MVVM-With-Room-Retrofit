package com.example.retrofitwithroomandmvvm

import android.app.Application
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.ApiService.RetrofitHelper
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import com.example.retrofitwithroomandmvvm.Room.Databse.DatabaseSet

class MainApplication : Application() {

    lateinit var repositorys: Repositorys

    override fun onCreate() {
        super.onCreate()
        initialized()
    }

    private fun initialized() {
        val apiServices = RetrofitHelper.instance().create(Apiservice::class.java)
        val databse = DatabaseSet.getDatabaseInstance(applicationContext)
        repositorys = Repositorys(apiServices, databse,applicationContext)

    }
}