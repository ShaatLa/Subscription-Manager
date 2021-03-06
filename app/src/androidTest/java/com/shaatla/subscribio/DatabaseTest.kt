package com.shaatla.subscribio

import android.content.Context
import android.graphics.Color
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shaatla.subscribio.infrastructure.database.SubscribioDatabase
import com.shaatla.subscribio.subscriptioninfo.gateway.boundary.SubscriptionInfoDao
import com.shaatla.subscribio.subscriptions.domain.model.NotificationPeriod
import com.shaatla.subscribio.subscriptions.gateway.boundary.SubscriptionsDao
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import org.hamcrest.CoreMatchers.equalTo
import org.joda.time.DateTime
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.UUID

/**
 * DatabaseTest
 * 03.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var dao: SubscriptionInfoDao
    private lateinit var db: SubscribioDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SubscribioDatabase::class.java).build()
        dao = db.getSubscriptionInfoDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadTest() {
        val id = UUID.randomUUID().toString()
        val subscriptionEntity: SubscriptionEntity = TestUtil.createSubscription(id)
        dao.save(subscriptionEntity)

        val subscriptionEntityFromDb = dao.get(id)
        assertThat(subscriptionEntity.id, equalTo(subscriptionEntityFromDb.id))
        assertThat(subscriptionEntity.provider, equalTo(subscriptionEntityFromDb.provider))
        assertThat(subscriptionEntity.expirationDate, equalTo(subscriptionEntityFromDb.expirationDate))
        assertThat(subscriptionEntity.price, equalTo(subscriptionEntityFromDb.price))
        assertThat(subscriptionEntity.currency, equalTo(subscriptionEntityFromDb.currency))
        assertThat(subscriptionEntity.creationDate, equalTo(subscriptionEntityFromDb.creationDate))
        assertThat(subscriptionEntity.lastEditTime, equalTo(subscriptionEntityFromDb.lastEditTime))
        assertThat(subscriptionEntity.color, equalTo(subscriptionEntityFromDb.color))
    }

    private class TestUtil {
        companion object {
            fun createSubscription(id: String) =
                SubscriptionEntity(
                    id = id,
                    icon = "",
                    provider = "Netflix",
                    expirationDate = DateTime().toString(),
                    price = 9.99f,
                    currency = "USD",
                    creationDate = DateTime().toString(),
                    lastEditTime = DateTime().toString(),
                    color = Color.parseColor(TEST_COLOR_CODE),
                    billingPeriod = 2,
                    notificationPeriod = 0,
                    doesNotificationNeed = false,
                    note = "",
                    paymentMethod = ""
                )
        }
    }

    companion object {
        private const val TEST_COLOR_CODE = "#F44336"
    }
}