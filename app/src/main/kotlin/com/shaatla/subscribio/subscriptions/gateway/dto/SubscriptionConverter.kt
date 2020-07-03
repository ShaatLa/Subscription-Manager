package com.shaatla.subscribio.subscriptions.gateway.dto

import android.graphics.Color
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import org.joda.time.DateTime
import java.util.Currency

/**
 * SubscriptionConverter
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionConverter {

    fun convert(entity: SubscriptionEntity): Subscription =
        Subscription(
            id = entity.id,
            provider = entity.provider,
            expirationDate = DateTime(entity.expirationDate),
            price = entity.price,
            currency = Currency.getInstance(entity.currency),
            creationDate = DateTime(entity.creationDate),
            lastEditTime = DateTime(entity.lastEditTime),
            color = Color.parseColor(entity.color)
        )

    fun convert(subscription: Subscription): SubscriptionEntity =
        SubscriptionEntity(
            id = subscription.id,
            provider = subscription.provider,
            expirationDate = subscription.expirationDate.toString(),
            price = subscription.price,
            currency = subscription.currency.currencyCode,
            creationDate = subscription.creationDate.toString(),
            lastEditTime = subscription.lastEditTime.toString(),
            color = subscription.color.toString()
        )
}