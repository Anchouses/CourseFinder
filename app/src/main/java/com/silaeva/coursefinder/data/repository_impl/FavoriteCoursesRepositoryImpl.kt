package com.silaeva.coursefinder.data.repository_impl

import android.content.Context
import androidx.room.Room
import com.silaeva.coursefinder.data.dao.FavoriteDatabase
import com.silaeva.coursefinder.data.data_model.FavoriteCourse
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.FavoriteCoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.Executor
import java.util.concurrent.Executors

const val DATABASE_NAME = "FavoriteCourses"

class FavoriteCoursesRepositoryImpl private constructor(context: Context): FavoriteCoursesRepository {

    private val database: FavoriteDatabase = Room.databaseBuilder(
        context.applicationContext,
        FavoriteDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val favoriteDao = database.favoriteDao()

    private val executor: Executor = Executors.newSingleThreadScheduledExecutor()

    override fun getSavedCourses(): Flow<List<CourseModel>> {
        val list: Flow<List<FavoriteCourse>> = favoriteDao.getSavedCourses()
        return list.map { item ->
            item.map { it ->
                CourseModel(
                    id = it.id,
                    name = it.name,
                    owner = it.owner,
                    summary = it.description,
                    review = it.rating,
                    date = it.date,
                    price = it.price,
                    imageUrl = it.imageUrl,
                    isSaved = true
                )
            }
        }
    }

    override fun saveCourse(favoriteCourse: FavoriteCourse) {
        executor.execute {
            favoriteDao.saveCourse(favoriteCourse)
        }
    }

    companion object {
        private var INSTANCE: FavoriteCoursesRepositoryImpl? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) INSTANCE = FavoriteCoursesRepositoryImpl(context)
        }

        fun get(): FavoriteCoursesRepositoryImpl {
            return INSTANCE ?: throw IllegalStateException("where is history repository?")
        }
    }
}