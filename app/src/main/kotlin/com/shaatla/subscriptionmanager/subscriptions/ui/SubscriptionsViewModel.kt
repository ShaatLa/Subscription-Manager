package com.shaatla.subscriptionmanager.subscriptions.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.shaatla.subscriptionmanager.R
import com.shaatla.subscriptionmanager.databinding.FragmentSubscriptionsBinding
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.BaseViewModel
import com.shaatla.subscriptionmanager.subscriptions.domain.boundary.SubscriptionsDomain
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

/**
 * CommentsViewModel
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsViewModel : BaseViewModel<FragmentSubscriptionsBinding>(),
    SubscriptionsBindings {

    override val layoutId: Int = R.layout.fragment_subscriptions

    private val subscriptionsDomain: SubscriptionsDomain by inject()

    override val isShowEmptyState = MutableLiveData<Boolean>(false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscriptionsAdapter()
    }

    override fun onCreateNewClick() {

    }

    private fun setupSubscriptionsAdapter() {
        //TODO Setup RecyclerView adapter

        viewScope.launch {
            subscriptionsDomain.observeSubscriptions().collect { subscriptions ->
                isShowEmptyState.postValue(subscriptions.isEmpty())

                //TODO Submit data to RecyclerView
            }
        }
    }
}