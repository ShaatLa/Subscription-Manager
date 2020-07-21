package com.shaatla.subscribio.subscriptioninfo.ui

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptions.domain.model.BillingPeriod
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import java.util.Currency
import java.util.Locale

/**
 * SubscriptionViewModel
 * 18.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoViewModel(
    private val subscriptionInfoDomain: SubscriptionInfoDomain,
    private val id: Long
) : ViewModel() {

    var subscription: Subscription = Subscription(
        id = 1L,
        provider = "",
        expirationDate = DateTime(),
        price = 0.00f,
        currency = Currency.getInstance(Locale.getDefault()),
        paymentMethod = "String",
        creationDate = DateTime(),
        lastEditTime = DateTime(),
        billingPeriod = BillingPeriod.MONTHLY,
        color = Color.GREEN,
        note = ""
    )

    val subscriptionLiveData = MutableLiveData<Subscription>()

    suspend fun getSubscriptionInfo() {
        subscriptionInfoDomain.getSubscriptionInfo(id).also {
            subscription = it
            subscriptionLiveData.postValue(it)
        }
    }

    fun deleteSubscription() {
        viewModelScope.launch {
            subscriptionInfoDomain //.deleteSubscription(id)
        }
    }


}