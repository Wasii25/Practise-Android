package com.example.libraryapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object LibraryApi {
    val retrofitService: LibraryApiService by lazy {
        retrofit.create(LibraryApiService::class.java)
    }
}