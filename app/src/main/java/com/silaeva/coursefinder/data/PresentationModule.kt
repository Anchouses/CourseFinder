package com.silaeva.coursefinder.data

import com.silaeva.coursefinder.presentation.bottom_nav_bar.BottomNavBarViewModel
import com.silaeva.coursefinder.presentation.course.CourseViewModel
import com.silaeva.coursefinder.presentation.enter.EnterViewModel
import com.silaeva.coursefinder.presentation.favorites.FavoritesViewModel
import com.silaeva.coursefinder.presentation.onboarding.OnboardingVIewModel
import com.silaeva.coursefinder.presentation.profile.ProfileViewModel
import com.silaeva.coursefinder.presentation.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<OnboardingVIewModel> {
        OnboardingVIewModel()
    }
    viewModel<RegistrationViewModel> {
        RegistrationViewModel()
    }
    viewModel<EnterViewModel> {
        EnterViewModel()
    }
    viewModel<CourseViewModel> {
        CourseViewModel()
    }
    viewModel<FavoritesViewModel> {
        FavoritesViewModel()
    }
    viewModel<ProfileViewModel> {
        ProfileViewModel()
    }
    viewModel<BottomNavBarViewModel> {
        BottomNavBarViewModel()
    }
}