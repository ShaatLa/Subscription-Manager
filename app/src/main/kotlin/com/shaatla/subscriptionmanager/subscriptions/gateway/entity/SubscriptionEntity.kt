package com.shaatla.subscriptionmanager.subscriptions.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shaatla.subscriptionmanager.subscriptions.gateway.entity.SubscriptionEntity.Companion.TABLE_NAME
import java.util.Currency

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
    @ColumnInfo(name = COLUMN_DATE)
    val expirationDate: String,
    @ColumnInfo(name = COLUMN_PRICE)
    val price: Float,
    @ColumnInfo(name = COLUMN_CURRENCY)
    val currency: Currency
) {

    companion object {
        const val TABLE_NAME = "subscription"

        const val COLUMN_ID = "id"

        const val COLUMN_DATE = "expiration_date"

        const val COLUMN_PRICE = "price"

        const val COLUMN_CURRENCY = "currency"
    }
}