package com.lucasfagundes.roga_labs.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(

                )
            ).androidContext(applicationContext)
        }
    }
}