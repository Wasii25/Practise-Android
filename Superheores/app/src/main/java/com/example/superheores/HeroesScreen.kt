package com.example.superheores

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheores.model.Hero


@Composable
fun HeroList(
    heroList: List<Hero>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        items(heroList) { hero ->
            HeroCard(
                name = hero.nameRes,
                desc = hero.descriptionRes,
                image = hero.imageRes
            )
        }
    }
}


@Composable
fun HeroCard(
    modifier: Modifier = Modifier,
    @StringRes name: Int,
    @StringRes desc: Int,
    @DrawableRes image: Int,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            2.dp
        ),
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    16.dp
                )
            )

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            HeroNameAndDesc(
                name = name,
                desc = desc,
                modifier = Modifier
                    .padding(
                        start = 16.dp
                    )
                    .weight(1F)

            )


            Spacer(
                modifier = Modifier
                    .width(
                        16.dp
                    )
            )

            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun HeroNameAndDesc(
    @StringRes name: Int,
    @StringRes desc: Int,
    modifier: Modifier = Modifier,
    ) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth(),
        ) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.displaySmall
    )
        Text(
            text = stringResource(desc),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

