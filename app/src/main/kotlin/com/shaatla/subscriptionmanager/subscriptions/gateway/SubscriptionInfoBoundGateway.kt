package com.shaatla.subscriptionmanager.subscriptions.gateway

import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionBoundGateway
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoBoundGateway: SubscriptionInfoGateway {

    override suspend fun observeSubscriptionInfo(id: Long): Flow<Subscription> {
        TODO("Not yet implemented")
    }
}