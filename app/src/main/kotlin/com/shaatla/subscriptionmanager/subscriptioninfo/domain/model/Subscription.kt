package com.shaatla.subscriptionmanager.subscriptioninfo.domain.model

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
    val expirationDate: DateTime,
    val decimal: Float,
    val currency: Currency
)