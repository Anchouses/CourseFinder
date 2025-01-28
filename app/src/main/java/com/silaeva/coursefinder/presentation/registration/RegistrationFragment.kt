package com.silaeva.coursefinder.presentation.registration

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.base.BaseFragment
import com.silaeva.coursefinder.presentation.data_source.Direction
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment: BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }

    @Composable
    override fun SetContent() {
        RegistrationScreen()
    }

    private val registrationViewModel: RegistrationViewModel by viewModel<RegistrationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                registrationViewModel.navigation.collect {
                    when (it) {
                        Direction.ENTER -> view.findNavController()
                            .navigate(
                                R.id.action_registrationFragment_to_enterFragment
                            )
                        else -> {}
                    }
                }
            }
        }
    }
}