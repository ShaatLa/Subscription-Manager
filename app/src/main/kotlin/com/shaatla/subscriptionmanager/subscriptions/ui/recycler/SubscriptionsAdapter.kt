package com.shaatla.subscriptionmanager.subscriptions.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.recycler.BaseAdapter
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription

/**
 * SubscriptionsAdapter
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsAdapter(
    bindings: SubscriptionItemBindings
) : BaseAdapter<Subscription, SubscriptionItemBindings, SubscriptionViewHolder>(bindings) {

    override fun getDiffUtilCallback(newItems: List<Subscription>): DiffUtil.Callback =
        SubscriptionsDiffUtilCallback(items, newItems)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder =
        SubscriptionViewHolder.create(parent)
}