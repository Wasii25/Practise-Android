package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
fun NameAndTitle(name: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.social)
    Icon(
        painter = image,
        contentDescription = null,
    )
    Text(
        text = stringResource(R.string.wasiullah_rafeeq_s),
    )
    Text(
        text = stringResource(R.string.title),
    )
}

@Composable
fun Contacts(modifier: Modifier = Modifier) {

}

