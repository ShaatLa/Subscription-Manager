package com.shaatla.subscriptionmanager.subscriptioninfo.domain

import android.graphics.Color
import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.joda.time.DateTime
import java.util.Currency

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