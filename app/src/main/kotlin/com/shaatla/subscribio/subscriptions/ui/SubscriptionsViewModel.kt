package com.shaatla.subscribio.subscriptions.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.model.Subscription

/**
 * SubscriptionsViewModel
 * 18.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsViewModel(
    private val subscriptionsDomain: SubscriptionsDomain
) : ViewModel() {

    fun observeSubscriptions(): LiveData<List<Subscription>> =
        subscriptionsDomain
            .observeSubscriptions()
            .asLiveData()
}