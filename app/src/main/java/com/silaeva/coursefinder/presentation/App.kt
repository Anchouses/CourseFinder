package com.silaeva.coursefinder.presentation

import android.app.Application
import com.silaeva.coursefinder.data.di.dataModule
import com.silaeva.coursefinder.data.di.presentationModule
import com.silaeva.coursefinder.data.repository_impl.FavoriteCoursesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        FavoriteCoursesRepositoryImpl.initialize(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(presentationModule, dataModule))
        }
    }
}