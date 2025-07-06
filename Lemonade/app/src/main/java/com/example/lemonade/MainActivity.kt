package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeWithTextAndImages(modifier: Modifier = Modifier) {
    var state by remember { mutableIntStateOf(1) }
    var result by remember { mutableIntStateOf((2..4).random()) }
    var clicks by remember { mutableIntStateOf(0) }

    val imageResource = when (state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF8E1) // Soft yellow background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        when (state) {
                            1 -> state = 2
                            2 -> {
                                clicks++
                                if (clicks >= result) {
                                    state = 3
                                    clicks = 0
                                    result = (2..4).random()
                                }
                            }
                            3 -> state = 4
                            4 -> state = 1
                        }
                    }
            )

            Spacer(modifier = Modifier.height(16.dp))

            when (state) {
                1 -> {
                    Text(
                        text = stringResource(R.string.select_lemon),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { state = 2 },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Pick Lemon")
                    }
                }

                2 -> {
                    Text(
                        text = stringResource(R.string.squeeze),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            clicks++
                            if (clicks >= result) {
                                state = 3
                                clicks = 0
                                result = (2..4).random()
                            }
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Squeeze Lemon ($clicks/$result)")
                    }
                }

                3 -> {
                    Text(
                        text = stringResource(R.string.drink),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { state = 4 },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Drink Lemonade")
                    }
                }

                4 -> {
                    Text(
                        text = stringResource(R.string.empty),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { state = 1 },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Restart")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeWithTextAndImages(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
