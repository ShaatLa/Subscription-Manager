package com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary

import com.shaatla.subscriptionmanager.subscriptioninfo.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionInfoDomain
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionInfoDomain {

    fun observeSubscription(id: Long): Flow<Subscription>
}