package com.silaeva.coursefinder.data.di

import com.silaeva.coursefinder.data.repository_impl.AuthRepositoryImpl
import com.silaeva.coursefinder.data.repository_impl.CoursesRepositoryImpl
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.repositories.AuthRepository
import com.silaeva.coursefinder.domain.repositories.CoursesRepository
import org.koin.dsl.module

val dataModule = module {

    single <RetrofitClient>{
        RetrofitClient
    }

    single <AuthRepository>{
        AuthRepositoryImpl(retrofitClient = get())
    }

    single <CoursesRepository>{
        CoursesRepositoryImpl(retrofitClient = get())
    }
}