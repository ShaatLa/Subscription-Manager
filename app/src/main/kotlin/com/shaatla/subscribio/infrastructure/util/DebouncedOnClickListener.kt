package com.shaatla.subscribio.infrastructure.util

import android.os.SystemClock
import android.view.View
import java.util.*

/**
 * DebouncedOnClickListener
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
abstract class DebouncedOnClickListener(private val minimumIntervalMilliseconds: Long = 300) :
    View.OnClickListener {

    private val lastClickMap: MutableMap<View, Long> = WeakHashMap()

    abstract fun onDebouncedClick(v: View)

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()

        lastClickMap[clickedView] = currentTimestamp

        if (previousClickTimestamp == null
            || Math.abs(currentTimestamp - previousClickTimestamp) > minimumIntervalMilliseconds
        ) {
            onDebouncedClick(clickedView)
        }
    }
}

fun View.setDebouncedOnClickListener(clickListener: (View) -> Unit) {
    setOnClickListener(object : DebouncedOnClickListener() {
        override fun onDebouncedClick(v: View) {
            clickListener(v)
        }
    })
}