package com.example.testtask

import android.app.Application
import com.example.testtask.BuildConfig.DEBUG
import com.example.testtask.data.utils.BASE_URL
import com.example.testtask.di.apiModule
import com.example.testtask.di.repositoryModule
import com.example.testtask.di.retrofitModule
import com.example.testtask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }

}