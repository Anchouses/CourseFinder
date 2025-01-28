package com.silaeva.coursefinder.presentation.enter

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

class EnterFragment: BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = EnterFragment()
    }

    @Composable
    override fun SetContent() {
        EnterScreen()
    }

    private val enterViewModel: EnterViewModel by viewModel<EnterViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                enterViewModel.navigation.collect {
                    when (it) {
                        Direction.MAIN -> view.findNavController()
                            .navigate(
                                R.id.action_enterFragment_to_bottomNavBarFragment
                            )
                        Direction.REGISTRATION -> view.findNavController()
                            .navigate(
                                R.id.action_enterFragment_to_registrationFragment
                            )
                        else -> {}
                    }
                }
            }
        }
    }
}