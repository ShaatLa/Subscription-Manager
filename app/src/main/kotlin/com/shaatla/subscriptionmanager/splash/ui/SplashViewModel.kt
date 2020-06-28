package com.shaatla.subscriptionmanager.splash.ui

import androidx.navigation.fragment.findNavController
import com.shaatla.subscriptionmanager.databinding.FragmentSplashScreenBinding
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.BaseViewModel
import java.util.Timer
import kotlin.concurrent.schedule

/**
 * SplashViewModel
 * 23.03.2020
 * Created by ShaatLa
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SplashViewModel : BaseViewModel<FragmentSplashScreenBinding>(), SplashBindings {

    override val layoutId: Int = com.shaatla.subscriptionmanager.R.layout.fragment_splash_screen

    override fun onResume() {
        super.onResume()

        Timer().schedule(1500) {
            findNavController().navigate(SplashViewModelDirections.toSubscriptions())
        }
    }
}