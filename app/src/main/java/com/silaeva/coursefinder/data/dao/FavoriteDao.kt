package com.silaeva.coursefinder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.silaeva.coursefinder.data.data_model.FavoriteCourse
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM FavoriteCourse")
    fun getSavedCourses(): Flow<List<FavoriteCourse>>

    @Insert
    fun saveCourse(courseModel: FavoriteCourse)
}