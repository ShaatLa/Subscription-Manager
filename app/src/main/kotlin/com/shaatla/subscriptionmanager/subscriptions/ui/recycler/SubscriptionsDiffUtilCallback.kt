package com.shaatla.subscriptionmanager.subscriptions.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription

/**
 * SubscriptionsDiffUtilCallback
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsDiffUtilCallback(
    private val oldItems: List<Subscription>,
    private val newItems: List<Subscription>
) : DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].expirationDate == newItems[newItemPosition].expirationDate &&
                oldItems[oldItemPosition].price == newItems[newItemPosition].price &&
                oldItems[oldItemPosition].provider == newItems[newItemPosition].provider &&
                oldItems[oldItemPosition].currency == newItems[newItemPosition].currency
}