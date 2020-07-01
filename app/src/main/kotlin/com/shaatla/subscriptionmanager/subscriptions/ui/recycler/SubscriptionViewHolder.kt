package com.shaatla.subscriptionmanager.subscriptions.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.shaatla.subscriptionmanager.R
import com.shaatla.subscriptionmanager.databinding.ItemSubscriptionBinding
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.recycler.BaseViewHolder
import com.shaatla.subscriptionmanager.subscriptions.domain.model.Subscription

/**
 * SubscriptionViewHolder
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionViewHolder(
    viewBinding: ItemSubscriptionBinding
): BaseViewHolder<Subscription, SubscriptionItemBindings, ItemSubscriptionBinding>(viewBinding) {

    companion object {
        fun create(parent: ViewGroup): SubscriptionViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemSubscriptionBinding = DataBindingUtil.inflate(inflater, R.layout.item_subscription, parent, false )

            return SubscriptionViewHolder(binding)
        }
    }
}