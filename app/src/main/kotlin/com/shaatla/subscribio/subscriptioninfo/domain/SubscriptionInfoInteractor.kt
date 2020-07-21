package com.shaatla.subscribio.subscriptioninfo.domain

import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription

/**
 * SubscriptionInfoInteractor
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoInteractor(
    private val gateway: SubscriptionInfoGateway
) : SubscriptionInfoDomain {

    override suspend fun getSubscription(id: Int): Subscription =
        gateway.getSubscription(id)

    override suspend fun save(subscription: Subscription) {
        gateway.save(subscription)
    }

    override suspend fun deleteSubscription(id: Int) {
        gateway.delete(id)
    }
}