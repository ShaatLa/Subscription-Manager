package com.shaatla.subscribio.subscriptions.ui.recycler

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * SubscriptionsItemTouchCallback
 * 31.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsItemTouchCallback : ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int = makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0)


    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean =
        if (recyclerView is SubscriptionsItemTouchHelper) {
            recyclerView.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
            true
        } else {
            false
        }


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //no-op
    }
}