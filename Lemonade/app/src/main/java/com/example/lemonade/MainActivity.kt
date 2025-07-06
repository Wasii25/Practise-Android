package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var state by remember { mutableStateOf(1) }
    val imageResource = when(state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF8E1)
    ) {
        when(state) {
            1 -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = stringResource(R.string.lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                state = 2
                            }
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = stringResource(R.string.select_lemon),
                        fontSize = 18.sp,
                    )
                }
            }

            2 -> {
                var result by remember { mutableIntStateOf((2..4).random()) }
                var clicks by remember { mutableIntStateOf(0) }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                if(clicks == result) state = 3
                                else {
                                    clicks++
                                }
                            }
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = stringResource(R.string.squeeze),
                        fontSize = 18.sp,
                    )
                }
            }

            3 -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                state = 4
                            }
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = stringResource(R.string.drink),
                        fontSize = 18.sp,
                    )
                }
            }

            4 -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                state = 1
                            }
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = stringResource(R.string.empty),
                        fontSize = 18.sp,
                    )
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