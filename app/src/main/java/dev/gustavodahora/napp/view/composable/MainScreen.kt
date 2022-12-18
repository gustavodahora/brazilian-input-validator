package dev.gustavodahora.napp.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.gustavodahora.napp.R
import dev.gustavodahora.napp.ui.theme.BackgroundNeutral
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.ui.theme.TextNeutral
import dev.gustavodahora.napp.ui.theme.Typography

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundNeutral),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = Typography.h1,
            color = TextNeutral
        )
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    NappTheme {
        MainScreen()
    }
}
