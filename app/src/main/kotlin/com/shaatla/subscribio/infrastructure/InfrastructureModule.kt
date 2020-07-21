package com.shaatla.subscribio.infrastructure

import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.google.gson.Gson
import com.shaatla.subscribio.infrastructure.database.SubscribioDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * InfrastructureModule
 * 23.03.2020
 * Created by ShaatLa
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
object InfrastructureModule {

    private const val BASE_URL = ""

    private const val DB_NAME = "subscribio.db"

    val module = module {

        fragment {
            NavHostFragment()
        }

        single {
            Room.databaseBuilder(
                get(),
                SubscribioDatabase::class.java,
                SubscribioDatabase.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        single {
            OkHttpClient.Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single {
            Gson()
        }

        factory {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }
}