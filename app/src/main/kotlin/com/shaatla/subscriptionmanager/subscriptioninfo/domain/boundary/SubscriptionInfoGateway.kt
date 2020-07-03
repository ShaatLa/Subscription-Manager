package com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary

import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionInfoGateway
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionInfoGateway {

    suspend fun observeSubscriptionInfo(id: Long): Flow<Subscription>
}