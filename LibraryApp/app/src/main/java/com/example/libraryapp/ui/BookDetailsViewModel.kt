package com.example.libraryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.network.LibraryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookDetailsViewModel : ViewModel() {
    private var _uiState = MutableStateFlow<BookDetailsUiState>(BookDetailsUiState.Loading)
    val uiState: StateFlow<BookDetailsUiState> = _uiState

    fun loadBookDetails(bookId: String) {
        viewModelScope.launch {
            _uiState.value = BookDetailsUiState.Loading

            try {
                val book = LibraryApi.retrofitService.getBookDetails(bookId)
                _uiState.value = BookDetailsUiState.Success(book)
            } catch (e: Exception) {
                _uiState.value = BookDetailsUiState.Error
            }
        }
    }
}