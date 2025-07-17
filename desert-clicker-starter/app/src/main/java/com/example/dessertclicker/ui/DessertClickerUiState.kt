package com.example.dessertclicker.ui

import com.example.dessertclicker.model.Dessert

data class DessertClickerUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val desserts: List<Dessert> = emptyList<Dessert>(),
) {
    val currentDessert: Dessert
       get() = desserts.getOrNull(currentDessertIndex) ?: Dessert(0, 0, 0)

    val currentDessertPrice: Int
        get() = currentDessert.price

    val currentDessertImageId: Int
        get() = currentDessert.imageId
}