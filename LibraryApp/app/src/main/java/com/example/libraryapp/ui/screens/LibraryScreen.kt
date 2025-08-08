package com.example.libraryapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.ui.LibraryViewModel
import com.example.libraryapp.ui.SearchUiState
import com.example.libraryapp.ui.components.BookListView
import com.example.libraryapp.ui.components.BookshelfTopAppBarWithSearch
import com.example.libraryapp.ui.components.WelcomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
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
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}