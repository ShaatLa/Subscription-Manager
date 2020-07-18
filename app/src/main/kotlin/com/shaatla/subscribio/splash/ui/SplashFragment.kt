package com.shaatla.subscribio.splash.ui

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

    override fun onResume() {
        super.onResume()

        Timer().schedule(1500) {
            findNavController().navigate(SplashFragmentDirections.toSubscriptions())
        }
    }
}