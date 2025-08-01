package com.example.amphibiansapp.ui

import com.example.amphibiansapp.model.Amphibian


sealed interface AmphibiansUiState {
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState
}