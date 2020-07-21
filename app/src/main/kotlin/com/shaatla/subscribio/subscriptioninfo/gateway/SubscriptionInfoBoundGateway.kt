package com.shaatla.subscribio.subscriptioninfo.gateway

import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.gateway.boundary.SubscriptionDao
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * SubscriptionInfoBoundGateway
 * 04.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoBoundGateway(
    private val subscriptionDao: SubscriptionDao,
    private val subscriptionConverter: SubscriptionConverter
) : SubscriptionInfoGateway {

    override suspend fun getSubscriptionInfo(id: Long): Subscription =
        subscriptionConverter.convert(subscriptionDao.get(id))
}