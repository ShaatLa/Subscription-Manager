package com.shaatla.subscribio.subscriptions.domain.model

import org.joda.time.DateTime
import java.util.Currency

/**
 * Subscription
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
data class Subscription(
    val id: Int,
    val icon: String,
    val provider: String,
    val price: Float,
    val currency: Currency,
    val paymentMethod: String,
    val creationDate: DateTime,
    val expirationDate: DateTime,
    val lastEditTime: DateTime,
    val billingPeriod: BillingPeriod,
    val color: Int,
    val note: String,
    val doesNotificationNeed: Boolean,
    val notificationPeriod: NotificationPeriod
)

enum class BillingPeriod {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY
}

enum class NotificationPeriod {
    NONE,
    IN_THE_SAME_DAY,
    ONE_DAY_BEFORE,
    THREE_DAYS_BEFORE,
    ONE_WEEK_BEFORE,
    ONE_MONTH_BEFORE
}
