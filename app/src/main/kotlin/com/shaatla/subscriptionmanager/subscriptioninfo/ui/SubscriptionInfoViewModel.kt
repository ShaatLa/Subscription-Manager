package com.shaatla.subscriptionmanager.subscriptioninfo.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.shaatla.subscriptionmanager.R
import com.shaatla.subscriptionmanager.databinding.FragmentSubscriptionInfoBinding
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.BaseViewModel

/**
 * SubscriptionInfoViewModel
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoViewModel : BaseViewModel<FragmentSubscriptionInfoBinding>() {

    override val layoutId: Int = R.layout.fragment_subscription_info

    private val args: SubscriptionInfoViewModelArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscriptionInfo()
    }

    private fun setupSubscriptionInfo() {
        when (args.subscriptionId) {
            0L -> {
                //TODO Show empty state
            }

            else -> {
                //TODO observe info from DB
            }
        }
    }
}