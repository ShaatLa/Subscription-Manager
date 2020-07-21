package com.shaatla.subscribio.subscriptions.domain.model

import androidx.annotation.ColorInt
import androidx.annotation.IntDef
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
    val id: Long,
    val provider: String,
    val expirationDate: DateTime,
    val price: Float,
    val currency: Currency,
    val paymentMethod: String,
    val creationDate: DateTime,
    val lastEditTime: DateTime,
    val billingPeriod: BillingPeriod,
    @ColorInt val color: Int,
    val note: String
)

enum class BillingPeriod {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY
}
