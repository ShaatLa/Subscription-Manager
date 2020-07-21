package com.shaatla.subscribio.subscriptions.gateway

import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.gateway.boundary.SubscriptionsDao
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * SubscriptionsLocalGateway
 * 21.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsLocalGateway(
    private val dao: SubscriptionsDao,
    private val subscriptionConverter: SubscriptionConverter
) : SubscriptionsGateway {

    override fun observeSubscriptions(): Flow<List<Subscription>> =
        dao.observeAll().map { list ->
            list.map { entity ->
                subscriptionConverter.convert(entity)
            }
        }
}