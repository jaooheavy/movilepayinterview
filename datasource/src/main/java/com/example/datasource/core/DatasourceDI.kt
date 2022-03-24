package com.example.datasource.core

import com.example.datasource.ConfigurationService
import com.example.datasource.provider.ConfigurationProvider
import com.example.datasource.provider.ConfigurationProviderImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DatasourceDI {
    private const val BASE_URL = "https://mpay-android-interview.herokuapp.com/android/interview/"

    val serviceDI = module {
        single<Retrofit>{
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }

        factory<ConfigurationService> { get<Retrofit>().create(ConfigurationService::class.java) }
    }

    val providerDI = module {
        factory<ConfigurationProvider> { ConfigurationProviderImpl(get()) }
    }

    val modules = serviceDI + providerDI
}