package com.shaatla.subscribio.subscriptioninfo.domain

import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

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

    override suspend fun observeSubscriptionInfo(id: Long): Flow<Subscription> =
        subscriptionInfoGateway.observeSubscriptionInfo(id)
//        flow {
//            // This is demo Subscription
//            emit(
//                Subscription(
//                    id = 1,
//                    creationDate = DateTime(),
//                    provider = "Netflix",
//                    price = 259.00f,
//                    currency = Currency.getInstance("USD"),
//                    expirationDate = DateTime().plusMonths(1),
//                    lastEditTime = DateTime(),
//                    color = Color.parseColor("#F44336")
//                )
//            )
//        }
}