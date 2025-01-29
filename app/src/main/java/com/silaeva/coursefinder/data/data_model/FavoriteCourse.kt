package com.silaeva.coursefinder.data.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteCourse(
    @PrimaryKey
    val id: Long,
    val name: String,
    val owner: Long,
    val description: String,
    val rating: String,
    val date: String,
    val price: String,
    val imageUrl: String
)