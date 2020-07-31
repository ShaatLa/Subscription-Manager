package com.shaatla.subscribio.subscriptioninfo.gateway.boundary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * SubscriptionDao
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@Dao
interface SubscriptionInfoDao {

    /**
     * Observe certain subscription
     *
     * @param id - ID of subscription which have to be observed
     * @return certain subscription flow
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun observe(id: String): Flow<SubscriptionEntity>

    /**
     * Return certain subscription
     *
     * @param id - ID of subscription which have to be returned
     * @return certain subscription
     */
    @Query("SELECT * FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun get(id: String): SubscriptionEntity

    /**
     * Save subscription into DB
     *
     * @param entity subscription which have to be saved
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(entity: SubscriptionEntity)

    /**
     * Delete Subscription by ID
     *
     * @param id id of subscription which have to be deleted
     */
    @Query("DELETE FROM ${SubscriptionEntity.TABLE_NAME} WHERE ${SubscriptionEntity.COLUMN_ID} = :id")
    fun delete(id: String)
}