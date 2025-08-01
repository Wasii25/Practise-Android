package com.example.amphibiansapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.ui.AmphibiansUiState

@Composable
fun HomeScreen(
    uiState: AmphibiansUiState,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is AmphibiansUiState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is AmphibiansUiState.Success -> {
            Column(modifier.padding(16.dp)) {
                uiState.amphibians.forEach {
                    Text(text = it.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = it.description)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
        is AmphibiansUiState.Error -> {
            Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Failed to load data")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onRetry) {
                    Text("Retry")
                }
            }
        }
    }
}
