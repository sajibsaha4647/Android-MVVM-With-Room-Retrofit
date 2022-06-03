package com.example.retrofitwithroomandmvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithroomandmvvm.Repository.Repositorys

class MainviewModelFactory (private val repositorys: Repositorys):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainviewModel(repositorys) as T
    }


}
