package com.shaatla.subscribio.subscriptions

import com.shaatla.subscribio.infrastructure.database.SubscribioDatabase
import com.shaatla.subscribio.subscriptions.domain.SubscriptionsInteractor
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscribio.subscriptions.domain.boundary.SubscriptionsGateway
import com.shaatla.subscribio.subscriptions.gateway.SubscriptionsLocalGateway
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import com.shaatla.subscribio.subscriptions.ui.SubscriptionsViewModel
import org.koin.android.viewmodel.dsl.viewModel
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

        viewModel {
            SubscriptionsViewModel(get())
        }

        factory<SubscriptionsDomain> {
            SubscriptionsInteractor(get())
        }

        factory<SubscriptionsGateway> {
            SubscriptionsLocalGateway(get(), get())
        }

        factory {
            SubscriptionConverter()
        }

        single {
            get<SubscribioDatabase>().getSubscriptionsDao()
        }
    }
}