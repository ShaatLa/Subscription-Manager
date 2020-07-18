package com.shaatla.subscribio.subscriptioninfo.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * SubscriptionInfoFragment
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoFragment(
    private val subscriptionInfoDomain: SubscriptionInfoDomain
) : Fragment(R.layout.fragment_subscription_info) {

    private val args: SubscriptionInfoFragmentArgs by navArgs()

    private val viewModel: SubscriptionInfoViewModel by viewModel {
        parametersOf(args.subscriptionId)
    }

    private val viewScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        obtainSubscriptionInfo()
    }

    private fun obtainSubscriptionInfo() {
        viewScope.launch {
            when (args.subscriptionId) {
                0L -> {
                    //TODO Show empty state
                }

                else -> {
                    subscriptionInfoDomain
                        .observeSubscriptionInfo(args.subscriptionId)
                        .collect { subscription ->
                            setupSubscription(subscription)
                        }
                }
            }
        }
    }

    private fun setupSubscription(subscription: Subscription) {

    }
}