package com.example.retrofitwithroomandmvvm.BackgroundWorker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.retrofitwithroomandmvvm.MainApplication
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteBackgroundWorker(private val context: Context,params:WorkerParameters):Worker {
    override fun doWork(): Result {
        val repositorys = (context as MainApplication).repositorys
        CoroutineScope(Dispatchers.IO).launch {

        }
    }
}