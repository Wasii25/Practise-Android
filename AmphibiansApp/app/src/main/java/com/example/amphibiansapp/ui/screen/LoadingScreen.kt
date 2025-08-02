package com.example.amphibiansapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amphibiansapp.R

@Composable
fun LoadingScreen() {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading...",
        modifier = Modifier.size(200.dp)
    )
}
