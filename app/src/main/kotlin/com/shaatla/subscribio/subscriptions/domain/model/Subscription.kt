package com.shaatla.subscribio.subscriptions.domain.model

import androidx.annotation.ColorInt
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
    val creationDate: DateTime,
    val lastEditTime: DateTime,
    @ColorInt val color: Int
)