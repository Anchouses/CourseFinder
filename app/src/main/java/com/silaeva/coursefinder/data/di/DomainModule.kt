package com.silaeva.coursefinder.data.di

import com.silaeva.coursefinder.domain.interactor.AuthInteractor
import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.domain.interactor.GetCoursesInteractor
import com.silaeva.coursefinder.domain.interactor_impl.AuthInteractorImpl
import com.silaeva.coursefinder.domain.interactor_impl.FavoriteCoursesInteractorImpl
import com.silaeva.coursefinder.domain.interactor_impl.GetCoursesInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single <AuthInteractor> { AuthInteractorImpl(get()) }

    single <GetCoursesInteractor> { GetCoursesInteractorImpl(get()) }

    single <FavoriteCoursesInteractor> { FavoriteCoursesInteractorImpl(get()) }
}

