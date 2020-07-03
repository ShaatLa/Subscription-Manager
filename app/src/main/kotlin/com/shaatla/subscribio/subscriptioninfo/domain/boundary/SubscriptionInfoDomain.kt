package com.shaatla.subscribio.subscriptioninfo.domain.boundary

import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionInfoDomain
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionInfoDomain {

    suspend fun observeSubscriptionInfo(id: Long): Flow<Subscription>
}