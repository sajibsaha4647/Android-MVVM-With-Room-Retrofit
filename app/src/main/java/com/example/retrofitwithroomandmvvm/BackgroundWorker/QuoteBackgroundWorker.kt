package com.example.retrofitwithroomandmvvm.BackgroundWorker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.retrofitwithroomandmvvm.MainApplication
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteBackgroundWorker(private val context: Context,params:WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        Log.d("CoroutineScope","CoroutineScope")
        val repositorys = (context as MainApplication).repositorys
        CoroutineScope(Dispatchers.IO).launch {
            repositorys.getQuotesackground()
        }
        return Result.success()
    }
}