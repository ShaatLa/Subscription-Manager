package com.shaatla.subscribio

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import com.shaatla.subscribio.subscriptions.domain.model.BillingPeriod
import com.shaatla.subscribio.subscriptions.domain.model.NotificationPeriod
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.gateway.dto.SubscriptionConverter
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import kotlinx.coroutines.runBlocking
import net.danlew.android.joda.JodaTimeAndroid
import org.hamcrest.CoreMatchers.equalTo
import org.joda.time.DateTime
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.io.InputStream
import java.util.Currency
import java.util.UUID


/**
 * SubscriptionConverterTest
 * 04.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionConverterTest {

    @Before
    fun prepareContext() {
        val context: Context = mock(Context::class.java)
        val appContext: Context = mock(Context::class.java)
        val resources: Resources = mock(Resources::class.java)
        `when`(resources.openRawResource(anyInt())).thenReturn(mock(InputStream::class.java))
        `when`(appContext.resources).thenReturn(resources)
        `when`(context.applicationContext).thenReturn(appContext)
        JodaTimeAndroid.init(context)
    }

    @Test
    fun conversionTest() {
        val converter = SubscriptionConverter()

        val id = UUID.randomUUID()
        val currentDate = DateTime()

        val entity = SubscriptionEntity(
            id = id.toString(),
            creationDate = currentDate.toString(),
            provider = "Netflix",
            price = 259.00f,
            currency = Currency.getInstance("USD").currencyCode,
            expirationDate = currentDate.plusMonths(1).toString(),
            lastEditTime = currentDate.toString(),
            color = Color.parseColor("#F44336"),
            billingPeriod = BillingPeriod.MONTHLY.ordinal,
            icon = "TeStIc",
            note = "This is Note",
            doesNotificationNeed = true,
            notificationPeriod = NotificationPeriod.THREE_DAYS_BEFORE.ordinal,
            paymentMethod = "Credit Card"
        )

        val subscription = Subscription(
            id = id,
            creationDate = currentDate,
            provider = "Netflix",
            price = 259.00f,
            currency = Currency.getInstance("USD"),
            expirationDate = currentDate.plusMonths(1),
            lastEditTime = currentDate,
            color = Color.parseColor("#F44336"),
            billingPeriod = BillingPeriod.MONTHLY,
            icon = "TeStIc",
            note = "This is Note",
            doesNotificationNeed = true,
            notificationPeriod = NotificationPeriod.THREE_DAYS_BEFORE,
            paymentMethod = "Credit Card"
        )

        runBlocking {
            assertThat(entity.id, equalTo(converter.convert(subscription).id))
            assertThat(entity.creationDate, equalTo(converter.convert(subscription).creationDate))
            assertThat(entity.provider, equalTo(converter.convert(subscription).provider))
            assertThat(entity.price, equalTo(converter.convert(subscription).price))
            assertThat(entity.currency, equalTo(converter.convert(subscription).currency))
            assertThat(
                entity.expirationDate,
                equalTo(converter.convert(subscription).expirationDate)
            )
            assertThat(entity.lastEditTime, equalTo(converter.convert(subscription).lastEditTime))
            assertThat(entity.color, equalTo(converter.convert(subscription).color))

            assertThat(subscription.id, equalTo(converter.convert(entity).id))
            assertThat(subscription.creationDate, equalTo(converter.convert(entity).creationDate))
            assertThat(subscription.provider, equalTo(converter.convert(entity).provider))
            assertThat(subscription.price, equalTo(converter.convert(entity).price))
            assertThat(subscription.currency, equalTo(converter.convert(entity).currency))
            assertThat(
                subscription.expirationDate,
                equalTo(converter.convert(entity).expirationDate)
            )
            assertThat(subscription.lastEditTime, equalTo(converter.convert(entity).lastEditTime))
            assertThat(subscription.billingPeriod, equalTo(converter.convert(entity).billingPeriod))
            assertThat(subscription.icon, equalTo(converter.convert(entity).icon))
            assertThat(subscription.doesNotificationNeed, equalTo(converter.convert(entity).doesNotificationNeed))
            assertThat(subscription.notificationPeriod, equalTo(converter.convert(entity).notificationPeriod))
            assertThat(subscription.paymentMethod, equalTo(converter.convert(entity).paymentMethod))
            assertThat(subscription.note, equalTo(converter.convert(entity).note))
        }
    }
}