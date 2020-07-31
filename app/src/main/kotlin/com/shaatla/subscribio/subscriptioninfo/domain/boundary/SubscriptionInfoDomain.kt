package com.shaatla.subscribio.subscriptioninfo.domain.boundary

import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * SubscriptionInfoDomain
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionInfoDomain {

    /**
     * Get subscription according it's id
     *
     * @param id ID of the subscription
     * @return Subscription from repository
     */
    suspend fun getSubscription(id: UUID): Subscription

    /**
     * Save subscription to local repository
     *
     * @param subscription to save
     */
    suspend fun save(subscription: Subscription)


    /**
     * Delete subscription from local repository
     *
     * @param id of subscription which have to be deleted
     */
    suspend fun deleteSubscription(id: UUID)
}