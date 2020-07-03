package com.shaatla.subscriptionmanager

import android.graphics.Color
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.shaatla.subscriptionmanager.subscriptioninfo.ui.SubscriptionInfoViewModel
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import org.joda.time.DateTime
import org.junit.Test
import java.util.Currency

/**
 * SubscriptionDomainTest
 * 03.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionDomainTest {

//    @Test
//    suspend fun firstTest() {
//        val mock = mock<Flow<Subscription>>() {
//            on { collect(FlowCollector<Subscription>) } doReturn flow {
//                emit(
//                    Subscription(
//                        id = 1,
//                        creationDate = DateTime(),
//                        provider = "Netflix",
//                        price = 259.00f,
//                        currency = Currency.getInstance("USD"),
//                        expirationDate = DateTime().plusMonths(1),
//                        lastEditTime = DateTime(),
//                        color = Color.parseColor("#F44336")
//                    )
//                )
//            }
//        }
//
//        val info = SubscriptionInfoViewModel(mock)
//    }
}