package com.shaatla.subscriptionmanager.subscriptioninfo.gateway

import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import com.shaatla.subscriptionmanager.subscriptions.gateway.boundary.SubscriptionDao
import com.shaatla.subscriptionmanager.subscriptions.gateway.dto.SubscriptionConverter
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

    override suspend fun observeSubscriptionInfo(id: Long): Flow<Subscription> =
        subscriptionDao
            .observe(id)
            .map { entity ->
                subscriptionConverter.convert(entity)
            }
}