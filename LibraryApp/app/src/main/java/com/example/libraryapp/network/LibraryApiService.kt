package com.example.libraryapp.network

import com.example.libraryapp.model.BookList
import com.example.libraryapp.model.Book
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LibraryApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookList

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): Book
}