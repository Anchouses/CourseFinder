package com.silaeva.coursefinder.presentation.onboarding

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.base.BaseFragment
import com.silaeva.coursefinder.presentation.presentation_model.Direction
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment: BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = OnboardingFragment()
    }

    @Composable
    override fun SetContent() {
        OnboardingScreen()
    }

    private val onboardingViewModel: OnboardingViewModel by viewModel<OnboardingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                onboardingViewModel.navigation.collect {
                    when (it) {
                        Direction.REGISTRATION -> view.findNavController()
                            .navigate(
                                R.id.action_onboardingFragment_to_registrationFragment
                            )
                        else -> {}
                    }
                }
            }
        }
    }
}