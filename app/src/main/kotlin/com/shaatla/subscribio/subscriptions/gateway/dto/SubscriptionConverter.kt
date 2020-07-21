package com.shaatla.subscribio.subscriptions.gateway.dto

import com.shaatla.subscribio.subscriptions.domain.model.BillingPeriod
import com.shaatla.subscribio.subscriptions.domain.model.NotificationPeriod
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
            icon = entity.icon,
            provider = entity.provider,
            expirationDate = DateTime(entity.expirationDate),
            price = entity.price,
            currency = Currency.getInstance(entity.currency),
            paymentMethod = entity.paymentMethod,
            creationDate = DateTime(entity.creationDate),
            lastEditTime = DateTime(entity.lastEditTime),
            billingPeriod = when (entity.billingPeriod) {
                0 -> BillingPeriod.DAILY
                1 -> BillingPeriod.WEEKLY
                2 -> BillingPeriod.MONTHLY
                else -> BillingPeriod.YEARLY
            },
            color = entity.color,
            note = entity.note,
            doesNotificationNeed = entity.doesNotificationNeed,
            notificationPeriod = when (entity.notificationPeriod) {
                0 -> NotificationPeriod.NONE
                1 -> NotificationPeriod.IN_THE_SAME_DAY
                2 -> NotificationPeriod.ONE_DAY_BEFORE
                3 -> NotificationPeriod.THREE_DAYS_BEFORE
                4 -> NotificationPeriod.ONE_WEEK_BEFORE
                else -> NotificationPeriod.ONE_MONTH_BEFORE
            }
        )

    fun convert(subscription: Subscription): SubscriptionEntity =
        SubscriptionEntity(
            id = subscription.id,
            icon = subscription.icon,
            provider = subscription.provider,
            expirationDate = subscription.expirationDate.toString(),
            price = subscription.price,
            currency = subscription.currency.currencyCode,
            paymentMethod = subscription.paymentMethod,
            creationDate = subscription.creationDate.toString(),
            lastEditTime = subscription.lastEditTime.toString(),
            billingPeriod = subscription.billingPeriod.ordinal,
            color = subscription.color,
            note = subscription.note,
            doesNotificationNeed = subscription.doesNotificationNeed,
            notificationPeriod = subscription.notificationPeriod.ordinal
        )
}