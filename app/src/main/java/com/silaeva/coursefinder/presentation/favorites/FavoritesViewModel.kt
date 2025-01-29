package com.silaeva.coursefinder.presentation.favorites

import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class FavoritesViewModel(
    private val favoriteCoursesInteractor: FavoriteCoursesInteractor
): BaseViewModel() {

    fun getCourses() = favoriteCoursesInteractor.getFavoriteCourses()

    override fun updateDirection(direction: Direction) {}
}