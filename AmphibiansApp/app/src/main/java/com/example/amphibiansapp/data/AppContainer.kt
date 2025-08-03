package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibiansApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val AmphibianRepository: AmphibiansRepository
}

class DefaultAppContainer: AppContainer {
    private val base_url = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val AmphibianRepository: AmphibiansRepository by lazy {
        NetworkAmphibiansRepository(retrofitService)
    }
}