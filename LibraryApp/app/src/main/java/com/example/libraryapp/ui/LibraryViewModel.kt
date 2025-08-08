package com.example.libraryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.network.LibraryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibraryViewModel: ViewModel() {

    private var _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Welcome)
    private var _searchQuery = MutableStateFlow("")
    val uiState: StateFlow<SearchUiState> = _uiState
    val searchQuery: StateFlow<String> = _searchQuery

    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun searchBooks(query: String = _searchQuery.value) {
        if(query.isBlank()) {
            _uiState.value = SearchUiState.Welcome
            return
        }

        _uiState.value = SearchUiState.Loading

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