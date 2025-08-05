package com.example.amphibiansapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibiansApplication
import com.example.amphibiansapp.data.AmphibiansRepository
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.network.AmphibiansApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AmphibiansViewModel(
    val amphibiansRepository: AmphibiansRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)

    val uiState: StateFlow<AmphibiansUiState> = _uiState

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibiansUiState.Loading

            _uiState.value = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: Exception) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.AmphibianRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }
}