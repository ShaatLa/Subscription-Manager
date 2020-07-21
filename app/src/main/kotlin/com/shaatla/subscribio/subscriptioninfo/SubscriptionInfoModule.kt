package com.shaatla.subscribio.subscriptioninfo

import com.shaatla.subscribio.infrastructure.database.SubscribioDatabase
import com.shaatla.subscribio.subscriptioninfo.domain.SubscriptionInfoInteractor
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoGateway
import com.shaatla.subscribio.subscriptioninfo.gateway.SubscriptionInfoLocalGateway
import com.shaatla.subscribio.subscriptioninfo.ui.SubscriptionInfoViewModel
import org.koin.android.viewmodel.dsl.viewModel
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

        viewModel {
            (id: Int) -> SubscriptionInfoViewModel(get(), id)
        }

        factory<SubscriptionInfoGateway> {
            SubscriptionInfoLocalGateway(get(), get())
        }

        factory<SubscriptionInfoDomain> {
            SubscriptionInfoInteractor(get())
        }

        single {
            get<SubscribioDatabase>().getSubscriptionInfoDao()
        }
    }
}