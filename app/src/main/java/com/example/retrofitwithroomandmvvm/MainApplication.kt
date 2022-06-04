package com.example.retrofitwithroomandmvvm

import android.app.Application
import android.provider.SyncStateContract
import android.util.Log
import androidx.constraintlayout.widget.ConstraintSet
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.ApiService.RetrofitHelper
import com.example.retrofitwithroomandmvvm.BackgroundWorker.QuoteBackgroundWorker
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import com.example.retrofitwithroomandmvvm.Room.Databse.DatabaseSet
import java.util.concurrent.TimeUnit

class MainApplication : Application() {

    lateinit var repositorys: Repositorys

    override fun onCreate() {
        super.onCreate()
        initialized()
//        setupWorker()
    }

    private fun setupWorker(){
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest = PeriodicWorkRequest.Builder(QuoteBackgroundWorker::class.java,1, TimeUnit.MINUTES).setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workerRequest)
        Log.d("CoroutineScope","CoroutineScope")
    }

    private fun initialized() {
        val apiServices = RetrofitHelper.instance().create(Apiservice::class.java)
        val databse = DatabaseSet.getDatabaseInstance(applicationContext)
        repositorys = Repositorys(apiServices, databse,applicationContext)

    }
}