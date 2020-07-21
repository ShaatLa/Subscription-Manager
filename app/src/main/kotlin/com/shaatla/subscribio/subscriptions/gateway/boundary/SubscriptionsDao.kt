package com.shaatla.subscribio.subscriptions.gateway.boundary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionDao
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@Dao
interface SubscriptionsDao {

    /**
     * Observe all subscriptions from DB
     *
     * @return subscriptions flow
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME}")
    fun observeAll(): Flow<List<SubscriptionEntity>>

    /**
     * Delete all subscription records from table
     */
    @Query("DELETE FROM ${SubscriptionEntity.TABLE_NAME}" )
    fun deleteAll()
}