package com.shaatla.subscribio.subscriptions.domain

import android.graphics.Color
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
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
class SubscriptionsInteractor(
    private val subscriptionInfoGateway: SubscriptionInfoGateway
) : SubscriptionsDomain {

    override fun observeSubscriptions(): Flow<List<Subscription>> =
        flow {
            //For demo purposes
            //emit(emptyList())

            //For demo purposes
            emit(
                listOf(
                    Subscription(
                        id = 1,
                        creationDate = DateTime(),
                        provider = "Netflix",
                        price = 19.99f,
                        currency = Currency.getInstance("USD"),
                        expirationDate = DateTime().plusMonths(1),
                        lastEditTime = DateTime(),
                        color = Color.parseColor("#F44336")
                    ),
                    Subscription(
                        id = 2,
                        creationDate = DateTime(),
                        provider = "Amazon Prime",
                        price = 12.99f,
                        currency = Currency.getInstance("USD"),
                        expirationDate = DateTime().plusMonths(1),
                        lastEditTime = DateTime(),
                        color = Color.parseColor("#F55446")
                    )
                )
            )
        }
}