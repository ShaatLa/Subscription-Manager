package com.shaatla.subscribio.splash.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shaatla.subscribio.R
import java.util.Timer
import kotlin.concurrent.schedule

/**
 * SplashViewModel
 * 23.03.2020
 * Created by ShaatLa
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SplashFragment : Fragment(R.layout.fragment_splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.navigationBarColor =
            resources.getColor(R.color.colorPrimary, null)
    }

    override fun onResume() {
        super.onResume()

        Timer().schedule(1500) {
            findNavController().navigate(SplashFragmentDirections.toSubscriptions())
        }
    }
}