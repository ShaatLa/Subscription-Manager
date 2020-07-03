package com.shaatla.subscribio.subscriptions.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shaatla.subscribio.subscriptions.gateway.entity.SubscriptionEntity.Companion.TABLE_NAME

/**
 * SubscriptionEntity
 * 30.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
@Entity(tableName = TABLE_NAME)
class SubscriptionEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,
    @ColumnInfo(name = COLUMN_PROVIDER)
    val provider: String,
    @ColumnInfo(name = COLUMN_DATE)
    val expirationDate: String,
    @ColumnInfo(name = COLUMN_PRICE)
    val price: Float,
    @ColumnInfo(name = COLUMN_CURRENCY)
    val currency: String,
    @ColumnInfo(name = COLUMN_CREATION_DATE)
    val creationDate: String,
    @ColumnInfo(name = COLUMN_LAST_EDIT_TIME)
    val lastEditTime: String,
    @ColumnInfo(name = COLUMN_COLOR)
    val color: String
) {

    companion object {
        const val TABLE_NAME = "subscription"

        const val COLUMN_ID = "id"

        const val COLUMN_PROVIDER = "provider"

        const val COLUMN_DATE = "expiration_date"

        const val COLUMN_PRICE = "price"

        const val COLUMN_CURRENCY = "currency"

        const val COLUMN_CREATION_DATE = "creation_date"

        const val COLUMN_LAST_EDIT_TIME = "last_edit_time"

        const val COLUMN_COLOR = "color"
    }
}