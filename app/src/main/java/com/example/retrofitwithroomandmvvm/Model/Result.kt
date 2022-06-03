package com.example.retrofitwithroomandmvvm.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotemodel")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quoteid:Long,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
//    val tags: List<String>
)