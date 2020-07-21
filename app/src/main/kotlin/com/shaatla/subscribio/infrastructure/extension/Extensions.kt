package com.shaatla.subscribio.infrastructure.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Extensions
 * 21.07.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */

fun showKeyboard(view: View) {
    if (view.requestFocus()) {
        val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun hideKeyboard(view: View) {
    val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}