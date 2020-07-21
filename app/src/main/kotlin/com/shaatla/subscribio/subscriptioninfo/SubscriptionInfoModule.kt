package com.shaatla.subscribio.subscriptioninfo

import com.shaatla.subscribio.subscriptioninfo.domain.SubscriptionInfoInteractor
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptioninfo.gateway.SubscriptionInfoBoundGateway
import com.shaatla.subscribio.subscriptioninfo.ui.SubscriptionInfoViewModel
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

        factory {
            (id: Long) -> SubscriptionInfoViewModel(get(), id)
        }

        factory<SubscriptionInfoGateway> {
            SubscriptionInfoBoundGateway(get(), get())
        }

        factory<SubscriptionInfoDomain> {
            SubscriptionInfoInteractor(get())
        }
    }
}