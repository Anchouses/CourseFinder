package com.silaeva.coursefinder.presentation.search

import com.silaeva.coursefinder.domain.repositories.CoursesRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class SearchViewModel(private val coursesRepository: CoursesRepository): BaseViewModel() {
    fun getCourses(searchText: String) = coursesRepository.getCourses(searchText)
    override fun updateDirection(direction: Direction) {}
}