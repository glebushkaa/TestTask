package com.example.testtask

import android.app.Application
import com.example.testtask.di.apiModule
import com.example.testtask.di.retrofitModule
import com.example.testtask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(viewModelModule, retrofitModule, apiModule))
        }
    }

}