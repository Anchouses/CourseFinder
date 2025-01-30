package com.silaeva.coursefinder.domain.interactor

import com.silaeva.coursefinder.data.data_model.FavoriteCourse
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.FavoriteCoursesRepository
import kotlinx.coroutines.flow.Flow

class FavoriteCoursesInteractor(private val favoriteCoursesRepository: FavoriteCoursesRepository) {

    fun getFavoriteCourses(): Flow<List<CourseModel>>{
        return favoriteCoursesRepository.getSavedCourses()
    }

    fun saveFavoriteCourse(courseModel: CourseModel, owner: String, review: String) {
        val savedCourseModel = FavoriteCourse(
            id = courseModel.id,
            name = courseModel.name,
            owner = owner,
            description = courseModel.summary,
            rating = review,
            date = courseModel.date,
            price = courseModel.price,
            imageUrl = courseModel.imageUrl
        )
        favoriteCoursesRepository.saveCourse(savedCourseModel)
    }
}