package com.silaeva.coursefinder.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.silaeva.coursefinder.databinding.FragmentBaseBinding
import com.silaeva.coursefinder.presentation.comon_ui.theme.CourseFinderTheme

abstract class BaseFragment: Fragment() {

    private lateinit var binding: FragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setContent {
            CourseFinderTheme {
                SetContent()
            }
        }
    }

    @Composable
    abstract fun SetContent()
}