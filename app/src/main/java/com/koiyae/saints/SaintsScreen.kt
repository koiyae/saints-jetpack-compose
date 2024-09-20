package com.koiyae.saints

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.koiyae.saints.model.Saint
import com.koiyae.saints.model.SaintsRepository.saints

@Composable
fun SaintApp() {
    Scaffold(
        topBar = {
            SaintsTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(saints) {
                SaintItem(
                    saint = it,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun SaintItem(
    saint: Saint,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                SaintInfo(
                    modifier = Modifier.weight(1f),
                    saintName = saint.nameRes,
                    saintDescription = saint.descriptionRes
                )
                Spacer(Modifier.width(16.dp))
                SaintImage(saint.imageRes)
            }
        }
    }
}

@Composable
fun SaintImage(
    @DrawableRes saintIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(saintIcon),
        alignment = Alignment.TopCenter,
        contentDescription = null
    )
}

@Composable
fun SaintInfo(
    @StringRes saintName: Int,
    @StringRes saintDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(saintName),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(saintDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaintsTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(id = R.drawable.rome),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.topbar),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}
