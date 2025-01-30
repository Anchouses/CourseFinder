package com.silaeva.coursefinder.presentation.bottom_nav_bar

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.silaeva.coursefinder.presentation.base.BaseFragment

class BottomNavBarFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = BottomNavBarFragment()
    }

    @Composable
    override fun SetContent() {
        BottomNavBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}