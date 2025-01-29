package com.silaeva.coursefinder.domain.repositories

import androidx.paging.PagingData
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    fun getCourses(searchText: String): Flow<PagingData<CourseModel>>
}