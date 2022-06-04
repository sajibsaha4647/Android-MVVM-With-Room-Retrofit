package com.example.retrofitwithroomandmvvm.Repository

sealed class Response<T>(val data:T? = null,val errorMessage:String? = null) {

    class Loading<T>(loading: T? =null) : Response<T>(loading)
    class Success<T> (data: T? =null): Response<T>(data = data)
    class Error<T> (errorMessage: String): Response<T>(errorMessage = errorMessage)

}