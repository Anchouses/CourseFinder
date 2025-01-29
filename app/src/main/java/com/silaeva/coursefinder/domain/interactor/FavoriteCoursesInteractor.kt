package com.silaeva.coursefinder.domain.interactor

import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.FavoriteCoursesRepository
import kotlinx.coroutines.flow.Flow

class FavoriteCoursesInteractor(private val favoriteCoursesRepository: FavoriteCoursesRepository) {

    fun getFavoriteCourses(): Flow<List<CourseModel>>{
        return favoriteCoursesRepository.getSavedCourses()
    }

    fun saveFavoriteCourse(courseModel: CourseModel) {
        favoriteCoursesRepository.saveCourse(courseModel)
    }
}