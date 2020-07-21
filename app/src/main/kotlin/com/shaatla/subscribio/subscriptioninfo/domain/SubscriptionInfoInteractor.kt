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
    private val subscriptionInfoGateway: SubscriptionInfoGateway
) : SubscriptionInfoDomain {

    override suspend fun getSubscriptionInfo(id: Long): Subscription =
        subscriptionInfoGateway.getSubscriptionInfo(id)
}