package com.silaeva.coursefinder.presentation.course

import androidx.compose.runtime.Composable
import com.silaeva.coursefinder.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseFragment: BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CourseFragment()
    }

    @Composable
    override fun SetContent() {
        CourseScreen()
    }

    private val courseViewModel: CourseViewModel by viewModel<CourseViewModel>()

}