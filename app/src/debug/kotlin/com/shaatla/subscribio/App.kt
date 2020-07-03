package com.shaatla.subscribio

import androidx.multidex.MultiDexApplication
import com.shaatla.subscribio.infrastructure.module.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * App
 * 23.03.2020
 * Created by ShaatLa
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()

        setupTimber()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)

            modules(Modules.modules)
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
