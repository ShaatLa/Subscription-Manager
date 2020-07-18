package com.shaatla.subscribio.subscriptions.ui.recycler

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
    private val onItemClickListener: (id: Long) -> Unit
): RecyclerView.Adapter<SubscriptionViewHolder>() {

    private var items: List<Subscription> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.support_simple_spinner_dropdown_item, parent, false)

        return SubscriptionViewHolder(
            view,
            onItemClickListener
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: SubscriptionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(newItems: List<Subscription>) {
        val callback = SubscriptionsDiffUtilCallback(items, newItems)
        val result = DiffUtil.calculateDiff(callback)

        items = newItems
        result.dispatchUpdatesTo(this)
    }

}