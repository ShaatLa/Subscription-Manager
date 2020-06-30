package com.shaatla.subscriptionmanager.subscriptioninfo.domain

import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscriptionmanager.subscriptioninfo.domain.model.Subscription
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
class SubscriptionInfoInteractor: SubscriptionInfoDomain {

    override fun observeSubscription(id: Long): Flow<Subscription> =
        flow {
            // This is demo Subscription
            emit(
                Subscription(1, DateTime(), 259.00f, Currency.getInstance("USD"))
            )
        }
}