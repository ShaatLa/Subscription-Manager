package com.shaatla.subscriptionmanager.subscriptions.domain

import com.shaatla.subscriptionmanager.subscriptions.domain.boundary.SubscriptionsDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * SubscriptionsDomain
 * 29.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsInteractor : SubscriptionsDomain {

    override fun observeSubscriptions(): Flow<List<Int>> =
        flow {
            emit(emptyList())
        }
}