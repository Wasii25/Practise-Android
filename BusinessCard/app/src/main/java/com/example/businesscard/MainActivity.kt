package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),

                ) {
                    Column (
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        NameAndTitle()
                        Contacts()
                    }
                }
            }
        }
    }
}

@Composable
fun NameAndTitle(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.social)
    Column(
        modifier =  Modifier.padding(bottom = 42.dp, top = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(72.dp)
        )
        Text(
            text = stringResource(R.string.wasiullah_rafeeq_s),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
@Composable
fun Contacts(modifier: Modifier = Modifier) {
    val iconSize = 20.dp
    val iconPadding = 8.dp

    Column(
        modifier = modifier.padding(bottom = 32.dp), // spacing below if needed
        verticalArrangement = Arrangement.spacedBy(8.dp) // spacing between rows
    ) {
        ContactRow(
            icon = painterResource(R.drawable.phone_call),
            text = stringResource(R.string.phone),
            iconSize = iconSize,
            iconPadding = iconPadding
        )
        ContactRow(
            icon = painterResource(R.drawable.instagram),
            text = stringResource(R.string.social),
            iconSize = iconSize,
            iconPadding = iconPadding
        )
        ContactRow(
            icon = painterResource(R.drawable.mail),
            text = stringResource(R.string.email),
            iconSize = iconSize,
            iconPadding = iconPadding
        )
    }
}

@Composable
fun ContactRow(
    icon: Painter,
    text: String,
    iconSize: Dp,
    iconPadding: Dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(iconSize)
                .padding(end = iconPadding)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
