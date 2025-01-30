package com.silaeva.coursefinder.presentation.app

import android.app.Application
import com.silaeva.coursefinder.data.di.dataModule
import com.silaeva.coursefinder.data.di.domainModule
import com.silaeva.coursefinder.data.di.presentationModule
import com.silaeva.coursefinder.data.repository_impl.FavoriteCoursesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, presentationModule))
        }

        FavoriteCoursesRepositoryImpl.initialize(this)
    }
}