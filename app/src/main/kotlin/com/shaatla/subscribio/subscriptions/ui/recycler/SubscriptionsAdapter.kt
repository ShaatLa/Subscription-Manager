package com.shaatla.subscribio.subscriptions.ui.recycler

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import java.util.Collections
import java.util.UUID

/**
 * SubscriptionsAdapter
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsAdapter(
    private val onItemClickListener: (id: UUID, action: ItemAction) -> Unit
): RecyclerView.Adapter<SubscriptionViewHolder>(), SubscriptionsItemTouchHelper {

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

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }
}