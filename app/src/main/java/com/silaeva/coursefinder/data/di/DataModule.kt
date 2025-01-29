package com.silaeva.coursefinder.data.di

import com.silaeva.coursefinder.data.CoursesPagingSource
import com.silaeva.coursefinder.data.RemoteDataSource
import com.silaeva.coursefinder.data.repository_impl.AuthRepositoryImpl
import com.silaeva.coursefinder.data.repository_impl.CoursesRepositoryImpl
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.repositories.AuthRepository
import com.silaeva.coursefinder.domain.repositories.CoursesRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitClient }

    single<CoursesApi> { RetrofitClient.coursesApi }

    single { CoursesPagingSource(get(), get()) }

    single { RemoteDataSource(get()) }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    single<CoursesRepository> { CoursesRepositoryImpl(get()) }
}