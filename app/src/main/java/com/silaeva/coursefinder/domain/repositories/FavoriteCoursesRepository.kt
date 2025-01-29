package com.silaeva.coursefinder.domain.repositories

import com.silaeva.coursefinder.domain.domain_model.CourseModel
import kotlinx.coroutines.flow.Flow


interface FavoriteCoursesRepository {

    fun getSavedCourses(): Flow<List<CourseModel>>

    fun saveCourse(courseModel: CourseModel)
}