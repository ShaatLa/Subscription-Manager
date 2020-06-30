package com.shaatla.subscriptionmanager.subscriptioninfo.ui

import androidx.lifecycle.LiveData

/**
 * SubscriptionInfoBindings
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
interface SubscriptionInfoBindings {
    fun onCloseButtonClick()

    val isNameEditModeEnabled: LiveData<Boolean>

    val isPriceEditModeEnabled: LiveData<Boolean>

    fun onExpirationDateEditClick()
}