package com.shaatla.subscribio.subscriptioninfo.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.android.synthetic.main.fragment_subscription_info.expirationDate
import kotlinx.android.synthetic.main.fragment_subscription_info.infoCloseButton
import kotlinx.android.synthetic.main.fragment_subscription_info.infoDeleteButton
import kotlinx.android.synthetic.main.fragment_subscription_info.price
import kotlinx.android.synthetic.main.fragment_subscription_info.priceCurrency
import kotlinx.android.synthetic.main.fragment_subscription_info.subscriptionName
import kotlinx.android.synthetic.main.item_subscription.deleteButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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
class SubscriptionInfoFragment : Fragment(R.layout.fragment_subscription_info) {

    private val args: SubscriptionInfoFragmentArgs by navArgs()

    private val viewModel: SubscriptionInfoViewModel by viewModel {
        parametersOf(args.subscriptionId)
    }

    private val viewScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()

        obtainSubscriptionInfo()
    }

    private fun setupButtons() {
        infoCloseButton.setOnClickListener {
            findNavController().popBackStack()
        }

        infoDeleteButton.setOnClickListener {
            viewModel.deleteSubscription()
        }
    }

    private fun obtainSubscriptionInfo() {
        viewScope.launch {
            when (args.subscriptionId) {
                0L -> {
                    infoDeleteButton.isGone = true
                    setupEditor()
                }

                else -> {
                    viewScope.launch {
                        viewModel.getSubscriptionInfo()
                    }

                    viewModel.subscriptionLiveData
                        .observe(
                            viewLifecycleOwner,
                            Observer { subscription ->
                                setupSubscription(subscription)
                            }
                        )
                }
            }
        }
    }

    private fun setupSubscription(subscription: Subscription) {
        subscriptionName.text.insert(0, subscription.provider)
        expirationDate.text = subscription.expirationDate.toLocalDate().toString()
        priceCurrency.text = subscription.currency.symbol
        price.text.insert(0, subscription.price.toString())

        setupEditor()
    }

    private fun setupEditor() {
        subscriptionName.doOnTextChanged { text, _, _, _ ->
            viewModel.subscription = viewModel.subscription.copy(provider = text.toString())

            if (infoDeleteButton.isGone) {
                infoDeleteButton.isVisible = true
            }
        }
    }
}