package com.silaeva.coursefinder.data.repository_impl

import androidx.paging.PagingData
import com.silaeva.coursefinder.data.RemoteDataSource
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.CoursesRepository
import kotlinx.coroutines.flow.Flow

class CoursesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CoursesRepository {

    override fun getCourses(searchText: String): Flow<PagingData<CourseModel>> =
        remoteDataSource.getCourses(searchText)

}