package com.shaatla.subscriptionmanager.subscriptions.domain.boundary

import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionsDomain
 * 29.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionsDomain {

    /**
     * Observes all subscriptions changes from database.
     *
     * @return Subscriptions list
     */
    fun observeSubscriptions(): Flow<List<Subscription>>
}