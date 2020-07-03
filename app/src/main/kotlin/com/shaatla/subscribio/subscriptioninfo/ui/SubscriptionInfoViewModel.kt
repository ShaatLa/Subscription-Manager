package com.shaatla.subscribio.subscriptioninfo.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.shaatla.subscribio.R
import com.shaatla.subscribio.databinding.FragmentSubscriptionInfoBinding
import com.shaatla.subscribio.infrastructure.structure.ui.BaseViewModel
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * SubscriptionInfoViewModel
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoViewModel(
    private val subscriptionInfoDomain: SubscriptionInfoDomain
) : BaseViewModel<FragmentSubscriptionInfoBinding>() {

    override val layoutId: Int = R.layout.fragment_subscription_info

    private val args: SubscriptionInfoViewModelArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscriptionInfo()
    }

    private fun setupSubscriptionInfo() {
        viewScope.launch {
            when (args.subscriptionId) {
                0L -> {
                    //TODO Show empty state
                }

                else -> {
                    subscriptionInfoDomain
                        .observeSubscriptionInfo(args.subscriptionId)
                        .collect { subscription ->
                            viewBinding.item = subscription
                        }
                }
            }
        }
    }
}