package com.example.libraryapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.libraryapp.R

@Composable
fun WelcomeScreen(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        Text(
            text = stringResource(R.string.welcome_to_the_bookshelf_app),
            style = MaterialTheme.typography.displayMedium
        )
    }
}