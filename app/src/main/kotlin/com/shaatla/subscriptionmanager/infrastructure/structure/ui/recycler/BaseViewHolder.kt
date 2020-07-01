package com.shaatla.subscriptionmanager.infrastructure.structure.ui.recycler

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shaatla.subscriptionmanager.BR

/**
 * BaseViewHolder
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
abstract class BaseViewHolder<Item, Bindings, V : ViewDataBinding>(
    private val viewDataBinding: V
) : RecyclerView.ViewHolder(viewDataBinding.root) {

    @CallSuper
    open fun bindTo(item: Item, bindings: Bindings) {
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.setVariable(BR.bindings, bindings)
        viewDataBinding.executePendingBindings()
    }
}