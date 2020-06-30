package com.shaatla.subscriptionmanager.subscriptioninfo.gateway.boundary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shaatla.subscriptionmanager.subscriptioninfo.gateway.entity.SubscriptionEntity
import kotlinx.coroutines.flow.Flow

/**
 * SubscriptionDao
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@Dao
interface SubscriptionDao {

    /**
     * Observe all subscriptions from DB
     *
     * @return subscriptions flow
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME}")
    fun observeAll(): Flow<List<SubscriptionEntity>>

    /**
     * Observe certain subscription
     *
     * @param id - ID of subscription which have to be observed
     * @return certain subscription flow
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun observe(id: Long): Flow<SubscriptionEntity>

    /**
     * Return certain subscription
     *
     * @param id - ID of subscription which have to be returned
     * @return certain subscription
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun get(id: Long): SubscriptionEntity

    /**
     * Save subscription into DB
     *
     * @param subscriptionEntity subscription which have to be saved
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(subscriptionEntity: SubscriptionEntity)

    /**
     * Delete Subscription by ID
     *
     * @param id id of subscription which have to be deleted
     */
    @Query("DELETE FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun delete(id: Long)
}