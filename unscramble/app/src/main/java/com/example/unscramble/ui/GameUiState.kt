package com.example.unscramble.ui
data class GameUiState(
    val isGameOver: Boolean = false,
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0,
    val currentWordCount: Int = 1,
)
