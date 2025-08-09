package com.example.libraryapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.ui.BookDetailsUiState
import com.example.libraryapp.ui.BookDetailsViewModel

@Composable
fun BookDetailsScreen(
    bookId: String,
    modifier: Modifier = Modifier,
    viewModel: BookDetailsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Load data when screen opens
    LaunchedEffect(bookId) {
        viewModel.loadBookDetails(bookId)
    }

    when (uiState) {
        is BookDetailsUiState.Loading -> {
            LoadingScreen(modifier = modifier)
        }
        is BookDetailsUiState.Success -> {
            val book = (uiState as BookDetailsUiState.Success).book
            Column(modifier = modifier.padding(16.dp)) {
                Text(book.volumeInfo.title ?: "No Title", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(8.dp))
                Text(book.volumeInfo.description ?: "No description available")
            }
        }
        is BookDetailsUiState.Error -> {
            Text("Failed to load book details", modifier = modifier)
        }
    }
}
