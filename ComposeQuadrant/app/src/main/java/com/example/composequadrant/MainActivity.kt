package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(text: String,title: String, color: Color, modifier: Modifier = Modifier) {
    Surface (
        color = color,
        modifier = modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(
                        bottom = 16.dp,
                    )
            )
            Text(
                text = text,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column {
        Row (
            modifier = Modifier.weight(1F)
        ){
            Quadrant(
                text = stringResource( R.string.text1),
                title = stringResource(R.string.title1),
                color = colorResource(R.color.color1),
                modifier = Modifier.weight(1F),
            )
            Quadrant(
                text = stringResource( R.string.text2),
                title = stringResource(R.string.title2),
                color = colorResource(R.color.color2),
                modifier = Modifier.weight(1F),
                )
        }
        Row (
            modifier = Modifier.weight(1F)
        ){
            Quadrant(
                text = stringResource( R.string.text3),
                title = stringResource(R.string.title3),
                color = colorResource(R.color.color3),
                modifier = Modifier.weight(1F),
                )
            Quadrant(
                text = stringResource( R.string.text4),
                title = stringResource(R.string.title4),
                color = colorResource(R.color.color4),
                modifier = Modifier.weight(1F),
                )
        }
    }
}