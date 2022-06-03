package com.example.retrofitwithroomandmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.ApiService.RetrofitHelper
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import com.example.retrofitwithroomandmvvm.ViewModel.MainviewModel
import com.example.retrofitwithroomandmvvm.ViewModel.MainviewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainviewModel: MainviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiServices =RetrofitHelper.instance().create(Apiservice::class.java)
        val repo = Repositorys(apiServices)
        mainviewModel = ViewModelProvider(this,MainviewModelFactory(repo)).get(MainviewModel::class.java)

        mainviewModel.quotes.observe(this, Observer {
            Log.d("success",it.page.toString())
        })

    }
}