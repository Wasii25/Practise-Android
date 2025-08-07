package com.example.libraryapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.ui.LibraryViewModel
import com.example.libraryapp.ui.SearchUiState

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel = viewModel(),
    modifier: Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    when(uiState) {
        is SearchUiState.Error -> ErrorScreen(modifier = modifier)
        is SearchUiState.Loading -> LoadingScreen(modifier = modifier)
        is SearchUiState.Success -> BookListView((uiState as SearchUiState.Success).books)
    }
}