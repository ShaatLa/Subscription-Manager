package com.shaatla.subscribio.subscriptions.ui.recycler

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.domain.model.Subscription

/**
 * SubscriptionsAdapter
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsAdapter(
    private val onItemClickListener: (id: Int) -> Unit
): RecyclerView.Adapter<SubscriptionViewHolder>() {

    private val items = mutableListOf<Subscription>()

    private val handler = Handler()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_subscription, parent, false)

        return SubscriptionViewHolder(
            view,
            onItemClickListener
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: SubscriptionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun submitList(newItems: List<Subscription>) {
        handler.post {
            val callback = SubscriptionsDiffUtilCallback(items, newItems)
            val result = DiffUtil.calculateDiff(callback)

            items.clear()
            items.addAll(newItems)
            result.dispatchUpdatesTo(this)
        }
    }

}