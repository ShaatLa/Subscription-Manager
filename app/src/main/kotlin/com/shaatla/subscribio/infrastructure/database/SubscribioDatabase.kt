package com.shaatla.subscribio.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shaatla.subscribio.subscriptions.gateway.boundary.SubscriptionDao
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity

/**
 * Database
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@Database(
    entities = [ SubscriptionEntity::class ],
    version = 1
)
abstract class SubscribioDatabase: RoomDatabase() {

    abstract fun subscriptionDao(): SubscriptionDao
}