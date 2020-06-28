package com.shaatla.subscriptionmanager.subscriptions.ui

import androidx.lifecycle.LiveData

/**
 * CommentsBindings
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionsBindings {
    fun onCreateNewClick()

    val isShowEmptyState: LiveData<Boolean>
}