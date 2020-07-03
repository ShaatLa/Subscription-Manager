package com.shaatla.subscribio

import android.content.Context
import android.graphics.Color
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shaatla.subscribio.infrastructure.database.SubscribioDatabase
import com.shaatla.subscribio.subscriptions.gateway.boundary.SubscriptionDao
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import org.hamcrest.CoreMatchers.equalTo
import org.joda.time.DateTime
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * DatabaseTest
 * 03.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var subscriptionDao: SubscriptionDao
    private lateinit var db: SubscribioDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SubscribioDatabase::class.java).build()
        subscriptionDao = db.subscriptionDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadTest() {
        val subscriptionEntity: SubscriptionEntity = TestUtil.createSubscription(SUBSCRIPTION_TEST_ID)
        subscriptionDao.save(subscriptionEntity)

        val subscriptionEntityFromDb = subscriptionDao.get(SUBSCRIPTION_TEST_ID)
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
            fun createSubscription(id: Long) =
                SubscriptionEntity(
                    id = id,
                    provider = "Netflix",
                    expirationDate = DateTime().toString(),
                    price = 9.99f,
                    currency = "USD",
                    creationDate = DateTime().toString(),
                    lastEditTime = DateTime().toString(),
                    color = Color.parseColor(TEST_COLOR_CODE).toString()
                )
        }
    }

    companion object {
        private const val SUBSCRIPTION_TEST_ID = 3L

        private const val TEST_COLOR_CODE = "#F44336"
    }
}