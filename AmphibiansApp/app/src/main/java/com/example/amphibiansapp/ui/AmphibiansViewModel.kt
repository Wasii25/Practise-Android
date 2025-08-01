package com.example.amphibiansapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.model.Amphibian
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)

    val uiState: StateFlow<AmphibiansUiState> = _uiState

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibiansUiState.Loading

            try {
                delay(1000)
                val fakeList = listOf(
                    Amphibian("Frog", "Rainforest", "A common frog", ""),
                    Amphibian("Salamander", "Mountains", "A slimy guy", "")
                )
                _uiState.value = AmphibiansUiState.Success(fakeList)
            } catch (e: Exception) {
                _uiState.value = AmphibiansUiState.Error
            }
        }
    }
}