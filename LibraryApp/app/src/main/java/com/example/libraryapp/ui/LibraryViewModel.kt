package com.example.libraryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.network.LibraryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibraryViewModel: ViewModel() {

    private var _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val uiState: StateFlow<SearchUiState> = _uiState

    init {
        searchBooks("android")
    }

    fun searchBooks(query: String) {
        _uiState.value = SearchUiState.Loading

        viewModelScope.launch {
            try {
                val response = LibraryApi.retrofitService.searchBooks(query)
                val books = response.items
                _uiState.value = SearchUiState.Success(books)
            } catch (e: Exception) {
                _uiState.value = SearchUiState.Error
            }
        }
    }
}