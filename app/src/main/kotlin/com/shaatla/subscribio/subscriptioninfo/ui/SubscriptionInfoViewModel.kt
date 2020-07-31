package com.shaatla.subscribio.subscriptioninfo.ui

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaatla.subscribio.subscriptioninfo.domain.boundary.SubscriptionInfoDomain
import com.shaatla.subscribio.subscriptions.domain.model.BillingPeriod
import com.shaatla.subscribio.subscriptions.domain.model.NotificationPeriod
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import java.util.Currency
import java.util.Locale
import java.util.UUID

/**
 * SubscriptionViewModel
 * 18.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoViewModel(
    private val domain: SubscriptionInfoDomain,
    private val id: UUID?
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    var baseSubscription: Subscription = Subscription(
        id = id ?: UUID.randomUUID(),
        icon = "",
        provider = "",
        expirationDate = DateTime(),
        price = 0.00f,
        currency = Currency.getInstance(Locale.getDefault()),
        paymentMethod = "String",
        creationDate = DateTime(),
        lastEditTime = DateTime(),
        billingPeriod = BillingPeriod.MONTHLY,
        color = Color.GREEN,
        note = "",
        doesNotificationNeed = false,
        notificationPeriod = NotificationPeriod.NONE
    )

    val subscriptionLiveData = MutableLiveData<Subscription>()

    override fun onCleared() {
        super.onCleared()

        viewModelScope.cancel()
    }

    fun getSubscriptionInfo() {
        viewModelScope.launch {
            if (id != null) {
                domain.getSubscription(id).also { subscription ->
                    baseSubscription = subscription
                    subscriptionLiveData.postValue(subscription)
                }
            }
        }
    }

    fun saveSubscription() {
        viewModelScope.launch {
            domain.save(baseSubscription)
        }
    }

    fun deleteSubscription() {
        viewModelScope.launch {
            if (id != null) {
                domain.deleteSubscription(id)
            }
        }
    }
}