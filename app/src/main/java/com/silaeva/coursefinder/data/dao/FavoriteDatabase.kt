package com.silaeva.coursefinder.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silaeva.coursefinder.data.data_model.FavoriteCourse


@Database(entities = [FavoriteCourse::class], version = 1)
abstract class FavoriteDatabase: RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}