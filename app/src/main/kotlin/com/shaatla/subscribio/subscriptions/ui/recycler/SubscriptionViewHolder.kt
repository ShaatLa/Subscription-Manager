package com.shaatla.subscribio.subscriptions.ui.recycler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shaatla.subscribio.subscriptions.domain.model.Subscription

/**
 * SubscriptionViewHolder
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionViewHolder(
    view: View,
    onItemClickListener: (id: Long) -> Unit
): RecyclerView.ViewHolder(view) {

    fun bind(subscription: Subscription) {

    }
}