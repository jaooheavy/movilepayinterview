package com.example.movilepayinterview.core

import android.app.Application
import com.example.movilepayinterview.core.KoinDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(KoinDI.modules)
        }
    }
}