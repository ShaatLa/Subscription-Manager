package com.shaatla.subscribio.infrastructure.module

import com.shaatla.subscribio.infrastructure.InfrastructureModule
import com.shaatla.subscribio.splash.SplashModule
import com.shaatla.subscribio.subscriptioninfo.SubscriptionInfoModule
import com.shaatla.subscribio.subscriptions.SubscriptionsModule

/**
 * Modules
 * v.1.0
 * 23.03.2020
 * Created by ShaatLa
 * shaatla@gmail.com
 * Copyright (c) 2019 ShaatLa. All rights reserved.
 */
object Modules {

    val modules = listOf(
        InfrastructureModule.module,
        SplashModule.module,
        SubscriptionsModule.module,
        SubscriptionInfoModule.module
    )
}