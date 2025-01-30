package com.silaeva.coursefinder.domain.interactor

import com.silaeva.coursefinder.domain.domain_model.CourseModel
import kotlinx.coroutines.flow.Flow

interface FavoriteCoursesInteractor {

    fun getFavoriteCourses(): Flow<List<CourseModel>>

    fun saveFavoriteCourse(courseModel: CourseModel, owner: String, review: String)
}