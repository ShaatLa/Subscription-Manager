package com.shaatla.subscribio.subscriptions.domain

import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsGateway
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
class SubscriptionsInteractor(
    private val gateway: SubscriptionsGateway
) : SubscriptionsDomain {

    override fun observeSubscriptions(): Flow<List<Subscription>> =
        gateway.observeSubscriptions()

    override suspend fun deleteSubscription(id: UUID) {
        gateway.deleteSubscription(id)
    }
}