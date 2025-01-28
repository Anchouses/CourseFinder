package com.silaeva.coursefinder.domain.repositories

import com.silaeva.coursefinder.domain.domain_model.CourseResponseModel

interface CoursesRepository {

    suspend fun getCourses(page: Int, size: Int): CourseResponseModel
}