package com.example.libraryapp.model


data class BookList(
    val items: List<Book>
)

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo,
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String?,
    val imageLinks: ImageLinks?,
)

data class ImageLinks(
    val thumbnail: String
)