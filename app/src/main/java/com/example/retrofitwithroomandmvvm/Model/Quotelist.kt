package com.example.retrofitwithroomandmvvm.Model

data class Quotelist(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)