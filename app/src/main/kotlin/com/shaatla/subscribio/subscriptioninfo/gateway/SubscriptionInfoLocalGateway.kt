package com.shaatla.subscribio.subscriptioninfo.gateway

import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptioninfo.gateway.boundary.SubscriptionInfoDao
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import java.util.UUID

/**
 * SubscriptionInfoBoundGateway
 * 04.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoLocalGateway(
    private val subscriptionInfoDao: SubscriptionInfoDao,
    private val subscriptionConverter: SubscriptionConverter
) : SubscriptionInfoGateway {

    override suspend fun getSubscription(id: UUID): Subscription =
        subscriptionConverter.convert(
            entity = subscriptionInfoDao.get(id.toString())
        )

    override suspend fun save(subscription: Subscription) {
        subscriptionInfoDao.save(
            entity = subscriptionConverter.convert(subscription)
        )
    }

    override suspend fun delete(id: UUID) {
        subscriptionInfoDao.delete(id.toString())
    }
}