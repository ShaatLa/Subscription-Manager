package com.shaatla.subscriptionmanager.infrastructure.module

import com.shaatla.subscriptionmanager.infrastructure.InfrastructureModule
import com.shaatla.subscriptionmanager.splash.SplashModule
import com.shaatla.subscriptionmanager.subscriptioninfo.SubscriptionInfoModule
import com.shaatla.subscriptionmanager.subscriptions.SubscriptionsModule

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