package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.determineDessertToShow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel: ViewModel() {
    private val desserts = com.example.dessertclicker.data.Datasource.dessertList

    private val _uiState = MutableStateFlow(
        DessertClickerUiState(desserts = desserts)
    )
    val uiState = _uiState.asStateFlow()

    fun onDessertClicked() {
        val currentState = _uiState.value
        val newRevenue = currentState.revenue + currentState.currentDessertPrice
        val newDessertsSold = currentState.dessertsSold + 1
        val dessertToShow = determineDessertToShow(desserts, newDessertsSold)
        val newIndex = desserts.indexOf(dessertToShow)

        _uiState.update {
            it.copy(
                revenue = newRevenue,
                dessertsSold = newDessertsSold,
                currentDessertIndex = newIndex
            )
        }

    }

}

