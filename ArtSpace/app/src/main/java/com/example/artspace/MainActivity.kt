package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(
    titleRes: Int,
    artistRes: Int,
    imageRes: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .widthIn(max = 600.dp)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = stringResource(titleRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(4f / 3f)
                    .shadow(
                        8.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                )
            Column {
                Text(
                    text = stringResource(titleRes),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall,
                    fontStyle = FontStyle.Normal,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(artistRes),
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onPrevious,
                    modifier = Modifier.weight(1f).height(IntrinsicSize.Min),
                ) {
                    Text(
                        text = stringResource(R.string.previous)
                    )
                }



                Button(
                    onClick = onNext,
                    modifier = Modifier.weight(1f).height(IntrinsicSize.Min),
                ) {
                    Text(
                        text = stringResource(R.string.next)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}


@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var currentArtwork by rememberSaveable { mutableStateOf(1) }

    // Map currentArtwork to resources
    val imageRes = when (currentArtwork) {
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        else -> R.drawable.seven
    }

    val titleRes = when (currentArtwork) {
        1 -> R.string.artwork_name_1
        2 -> R.string.artwork_name_2
        3 -> R.string.artwork_name_3
        4 -> R.string.artwork_name_4
        5 -> R.string.artwork_name_5
        6 -> R.string.artwork_name_6
        else -> R.string.artwork_name_7
    }

    val artistRes = when (currentArtwork) {
        1 -> R.string.artist_name_1
        2 -> R.string.artist_name_2
        3 -> R.string.artist_name_3
        4 -> R.string.artist_name_4
        5 -> R.string.artist_name_5
        6 -> R.string.artist_name_6
        else -> R.string.artist_name_7
    }

    ArtSpaceApp(
        imageRes = imageRes,
        titleRes = titleRes,
        artistRes = artistRes,
        onPrevious = {
            currentArtwork = if (currentArtwork > 1) currentArtwork - 1 else 7
        },
        onNext = {
            currentArtwork = if (currentArtwork < 7) currentArtwork + 1 else 1
        },
        modifier = modifier
    )
}
