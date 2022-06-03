package com.example.retrofitwithroomandmvvm.Room.Database.DatabaseModel

import androidx.room.Entity
import androidx.room.PrimaryKey



data class QuoteModel (
    val quoteid:Long,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)