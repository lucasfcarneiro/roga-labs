package com.lucasfagundes.roga_labs.base_app

import android.app.Application
import com.lucasfagundes.roga_labs.feature.posts.di.postsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                postsModule
            ).androidContext(applicationContext)
        }
    }
}