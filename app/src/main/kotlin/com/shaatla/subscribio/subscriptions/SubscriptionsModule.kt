package com.shaatla.subscribio.subscriptions

import com.shaatla.subscribio.subscriptions.domain.SubscriptionsInteractor
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import org.koin.dsl.module

/**
 * CommentsModule
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
object SubscriptionsModule {

    val module = module {

        factory<SubscriptionsDomain> {
            SubscriptionsInteractor(get())
        }

        factory {
            SubscriptionConverter()
        }
    }
}