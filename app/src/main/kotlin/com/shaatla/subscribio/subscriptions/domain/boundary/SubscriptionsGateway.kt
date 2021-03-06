package com.shaatla.subscribio.subscriptions.domain.boundary

import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * SubscriptionsDomain
 * 29.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionsGateway {

    /**
     * Observes all subscriptions changes from database.
     *
     * @return Subscriptions list
     */
    fun observeSubscriptions(): Flow<List<Subscription>>


    /**
     * Deletes subscription
     *
     * @param id of subscription which have to be deleted
     */
    suspend fun deleteSubscription(id: UUID)
}