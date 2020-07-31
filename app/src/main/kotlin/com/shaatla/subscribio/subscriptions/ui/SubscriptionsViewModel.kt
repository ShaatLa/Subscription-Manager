package com.shaatla.subscribio.subscriptions.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.UUID

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

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCleared() {
        super.onCleared()

        viewModelScope.cancel()
    }

    fun observeSubscriptions(): LiveData<List<Subscription>> =
        subscriptionsDomain
            .observeSubscriptions()
            .asLiveData()

    fun deleteSubscription(id: UUID) =
        viewModelScope.launch {
            subscriptionsDomain.deleteSubscription(id)
        }
}