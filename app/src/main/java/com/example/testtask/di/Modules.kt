package com.example.testtask.di

import com.example.testtask.data.repository.ImagesRepository
import com.example.testtask.data.retrofit.GifApi
import com.example.testtask.data.utils.BASE_URL
import com.example.testtask.ui.preview.viewModel.PreviewViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        PreviewViewModel(get())
    }
}

val repositoryModule = module {
    single {
        ImagesRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): GifApi {
        return retrofit.create(GifApi::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun provideRetrofit(
        factory: Gson,
        client: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(factory))
        .client(client)
        .build()

    fun provideGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    fun provideHttpClient() = OkHttpClient.Builder().build()

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}