package com.silaeva.coursefinder.presentation.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.silaeva.coursefinder.data.CoursesPagingSource
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.CoursesRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class SearchViewModel(private val coursesRepository: CoursesRepository): BaseViewModel() {

    fun getPager(): Pager<Int, CourseModel> {
        return Pager(PagingConfig(pageSize = 10)) {
            CoursesPagingSource(coursesRepository)
        }
    }

    override fun updateDirection(direction: Direction) {
    }
}