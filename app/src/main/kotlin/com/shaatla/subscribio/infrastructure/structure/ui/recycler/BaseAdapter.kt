package com.shaatla.subscribio.infrastructure.structure.ui.recycler

import android.os.Handler
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * BaseAdapter
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
abstract class BaseAdapter<Item, Bindings, VH: BaseViewHolder<Item, Bindings, *>>(
    private val bindings: Bindings
): RecyclerView.Adapter<VH>() {

    protected val items = mutableListOf<Item>()

    private val handler = Handler()

    abstract fun getDiffUtilCallback(newItems: List<Item>): DiffUtil.Callback

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindTo(items[position], bindings)
    }

    open fun submitList(newItems: List<Item>) {
        handler.post {
            val result = DiffUtil.calculateDiff(getDiffUtilCallback(newItems))

            items.clear()
            items.addAll(newItems)
            result.dispatchUpdatesTo(this)
        }
    }
}