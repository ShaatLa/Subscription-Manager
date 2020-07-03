package com.shaatla.subscribio.subscriptions.gateway

import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
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