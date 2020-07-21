package com.shaatla.subscribio.subscriptions.ui.recycler

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.android.synthetic.main.item_subscription.view.currency
import kotlinx.android.synthetic.main.item_subscription.view.price
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionDate
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionLogoBackground
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionName


/**
 * SubscriptionViewHolder
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionViewHolder(
    private val view: View,
    private val onItemClickListener: (id: Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(subscription: Subscription) {
        view.subscriptionName.text = subscription.provider
        view.subscriptionDate.text = view.context
            .getString(
                R.string.till_date,
                subscription.expirationDate.toLocalDate()
            )
        view.currency.text = subscription.currency.symbol
        view.price.text = subscription.price.toString()

        val gradientColors = IntArray(2).apply {
            this[0] = subscription.color
            this[1] = Color.WHITE
        }
        val gradient =
            GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors).apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadii = floatArrayOf(20f, 20f, 0f, 0f, 0f, 0f, 20f, 20f)
            }
        view.subscriptionLogoBackground.setImageDrawable(gradient)

        view.setOnClickListener {
            onItemClickListener.invoke(subscription.id)
        }
    }
}