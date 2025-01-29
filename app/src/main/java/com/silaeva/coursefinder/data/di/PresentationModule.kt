package com.silaeva.coursefinder.data.di

import com.silaeva.coursefinder.presentation.course.CourseViewModel
import com.silaeva.coursefinder.presentation.enter.EnterViewModel
import com.silaeva.coursefinder.presentation.favorites.FavoritesViewModel
import com.silaeva.coursefinder.presentation.onboarding.OnboardingViewModel
import com.silaeva.coursefinder.presentation.profile.ProfileViewModel
import com.silaeva.coursefinder.presentation.registration.RegistrationViewModel
import com.silaeva.coursefinder.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<OnboardingViewModel> {
        OnboardingViewModel()
    }
    viewModel<RegistrationViewModel> {
        RegistrationViewModel(get())
    }
    viewModel<EnterViewModel> {
        EnterViewModel(get())
    }
    viewModel<SearchViewModel> {
        SearchViewModel(get(), get())
    }
    viewModel<CourseViewModel> {
        CourseViewModel()
    }
    viewModel<FavoritesViewModel> {
        FavoritesViewModel(get())
    }
    viewModel<ProfileViewModel> {
        ProfileViewModel()
    }
}