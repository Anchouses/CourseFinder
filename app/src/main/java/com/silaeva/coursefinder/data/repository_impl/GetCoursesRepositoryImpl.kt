package com.silaeva.coursefinder.data.repository_impl

import androidx.paging.PagingData
import com.silaeva.coursefinder.data.paging.RemoteDataSource
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import kotlinx.coroutines.flow.Flow

class GetCoursesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : GetCoursesRepository {

    override fun getCourses(searchText: String): Flow<PagingData<CourseModel>> =
        remoteDataSource.getCourses(searchText)

}