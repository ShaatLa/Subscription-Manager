package com.shaatla.subscriptionmanager.subscriptions.domain

import com.shaatla.subscriptionmanager.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.joda.time.DateTime
import java.util.Currency

/**
 * SubscriptionsDomain
 * 29.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsInteractor : SubscriptionsDomain {

    override fun observeSubscriptions(): Flow<List<Subscription>> =
        flow {
            //For demo purposes
            //emit(emptyList())

            //For demo purposes
            emit(
                listOf(
                    Subscription(
                        id = 1,
                        creationDate = DateTime().minusWeeks(1),
                        provider = "Netflix",
                        expirationDate = DateTime().plusMonths(1),
                        price = 9.99f,
                        currency = Currency.getInstance("USD")
                    ),
                    Subscription(
                        id = 2,
                        creationDate = DateTime(),
                        provider = "Amazon Prime",
                        expirationDate = DateTime().plusMonths(1),
                        price = 14.99f,
                        currency = Currency.getInstance("USD")
                    )
                )
            )
        }
}