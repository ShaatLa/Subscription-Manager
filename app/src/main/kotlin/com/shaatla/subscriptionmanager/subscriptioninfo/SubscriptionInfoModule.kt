package com.shaatla.subscriptionmanager.subscriptioninfo

import com.shaatla.subscriptionmanager.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscriptionmanager.subscriptioninfo.gateway.SubscriptionInfoBoundGateway
import org.koin.dsl.module

/**
 * SubscriptionInfoModule
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
object SubscriptionInfoModule {

    val module = module {

        factory<SubscriptionInfoGateway> {
            SubscriptionInfoBoundGateway(get(), get())
        }
    }
}