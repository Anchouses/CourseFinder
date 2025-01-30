package com.silaeva.coursefinder.data.di

import com.silaeva.coursefinder.data.paging.CoursesPagingSource
import com.silaeva.coursefinder.data.paging.RemoteDataSource
import com.silaeva.coursefinder.data.repository_impl.AuthRepositoryImpl
import com.silaeva.coursefinder.data.repository_impl.FavoriteCoursesRepositoryImpl
import com.silaeva.coursefinder.data.repository_impl.GetCoursesRepositoryImpl
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.domain.repositories.AuthRepository
import com.silaeva.coursefinder.domain.repositories.FavoriteCoursesRepository
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitClient }

    single<CoursesApi> { RetrofitClient.coursesApi }

    single { CoursesPagingSource(get(), get()) }

    single { RemoteDataSource(get()) }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    single<GetCoursesRepository> { GetCoursesRepositoryImpl(get(), get()) }

    single <FavoriteCoursesRepository> {
        FavoriteCoursesRepositoryImpl.get()
    }

    single { FavoriteCoursesInteractor(get()) }
}