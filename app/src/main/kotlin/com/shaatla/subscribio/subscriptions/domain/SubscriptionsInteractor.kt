package com.shaatla.subscribio.subscriptions.domain

import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsGateway
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

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

//            For demo purposes
//            emit(
//                listOf(
//                    Subscription(
//                        id = 1,
//                        creationDate = DateTime(),
//                        provider = "Netflix",
//                        price = 19.99f,
//                        currency = Currency.getInstance("USD"),
//                        expirationDate = DateTime().plusMonths(1),
//                        lastEditTime = DateTime(),
//                        color = Color.parseColor("#f44336")
//                    ),
//                    Subscription(
//                        id = 2,
//                        creationDate = DateTime(),
//                        provider = "Amazon Prime",
//                        price = 12.99f,
//                        currency = Currency.getInstance("USD"),
//                        expirationDate = DateTime().plusMonths(1),
//                        lastEditTime = DateTime(),
//                        color = Color.parseColor("#1bab2c")
//                    )
//                )
//            )
}