package com.silaeva.coursefinder.domain.interactor

import androidx.paging.PagingData
import com.silaeva.coursefinder.data.data_model.CourseOwner
import com.silaeva.coursefinder.data.data_model.CourseReview
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import kotlinx.coroutines.flow.Flow

interface GetCoursesInteractor {

    fun getCourses(searchText: String): Flow<PagingData<CourseModel>>

    suspend fun getReview(id: Long): CourseReview

    suspend fun getOwner(id: Long): CourseOwner
}