package com.shaatla.subscribio.subscriptions.ui.recycler

import android.graphics.drawable.GradientDrawable
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.shaatla.subscribio.R
import com.shaatla.subscribio.infrastructure.util.setDebouncedOnClickListener
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.android.synthetic.main.item_subscription.view.currency
import kotlinx.android.synthetic.main.item_subscription.view.deleteButton
import kotlinx.android.synthetic.main.item_subscription.view.price
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionDate
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionLogo
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionLogoBackground
import kotlinx.android.synthetic.main.item_subscription.view.subscriptionName
import timber.log.Timber
import java.util.UUID


/**
 * SubscriptionViewHolder
 * 01.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionViewHolder(
    private val view: View,
    private val onItemClickListener: (id: UUID, action: ItemAction) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(subscription: Subscription) {
        view.subscriptionLogo.text = subscription.icon
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
            this[1] = view.solidColor
        }
        val gradient =
            GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gradientColors).apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadii = floatArrayOf(20f, 20f, 0f, 0f, 0f, 0f, 20f, 20f)
            }
        view.subscriptionLogoBackground.setImageDrawable(gradient)

        //TODO Refactor
        var lastAction = 0
        view.setOnTouchListener { view, event ->
            Timber.d("%d %d", event.action, event.historySize)
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    if (lastAction == MotionEvent.ACTION_MOVE) {
                        false
                    } else {
                        if (view is SwipeLayout && view.openStatus == SwipeLayout.Status.Open) {
                            lastAction = 0
                            view.close()
                            true
                        } else {
                            lastAction = 0
                            view.performClick()
                            onItemClickListener.invoke(subscription.id, ItemAction.NAVIGATE)
                            true
                        }
                    }
                }

                else -> {
                    lastAction = event.action
                    false
                }
            }
        }

        view.deleteButton.setOnClickListener {
            onItemClickListener.invoke(subscription.id, ItemAction.DELETE)
        }
    }
}