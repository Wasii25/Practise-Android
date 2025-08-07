package com.example.libraryapp.ui

import com.example.libraryapp.model.Book

sealed interface SearchUiState {
    data class Success(val books: List<Book>): SearchUiState
    object Error: SearchUiState
    object Loading: SearchUiState
}

sealed interface BookDetailsUiState {
    object Loading : BookDetailsUiState
    data class Success(val book: Book) : BookDetailsUiState
    object Error : BookDetailsUiState
}
