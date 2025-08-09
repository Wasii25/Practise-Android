package com.example.libraryapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.ui.LibraryViewModel
import com.example.libraryapp.ui.SearchUiState
import com.example.libraryapp.ui.components.BookListView
import com.example.libraryapp.ui.components.BookshelfTopAppBarWithSearch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    onBookClick: (String) -> Unit,
    viewModel: LibraryViewModel = viewModel(),
    modifier: Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Scaffold (
        topBar = {
            BookshelfTopAppBarWithSearch(
                searchQuery = searchQuery,
                onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
                onSearch = { viewModel.searchBooks() }
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is SearchUiState.Welcome -> WelcomeScreen(modifier = modifier.padding(innerPadding))
            is SearchUiState.Error -> ErrorScreen(modifier = modifier.padding(innerPadding))
            is SearchUiState.Loading -> LoadingScreen(modifier = modifier.padding(innerPadding))
            is SearchUiState.Success -> BookListView(
                (uiState as SearchUiState.Success).books,
                onBookClick = onBookClick,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}