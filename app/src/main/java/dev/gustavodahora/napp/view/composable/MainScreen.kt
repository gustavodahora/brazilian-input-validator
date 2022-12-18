package dev.gustavodahora.napp.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gustavodahora.napp.R
import dev.gustavodahora.napp.ui.theme.BackgroundNeutral
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.ui.theme.TextNeutral
import dev.gustavodahora.napp.ui.theme.Typography
import dev.gustavodahora.napp.view.viewModel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel?
) {
    var textCnpj by remember { mutableStateOf(TextFieldValue(text = "")) }

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
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = textCnpj,
            onValueChange = { text ->
                textCnpj = text
            },
            label = { Text(text = "CNPJ")},
            placeholder = { Text(text = "Enter your CNPJ")}
        )
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = textCnpj,
            onValueChange = { text ->
                textCnpj = text
            },
            label = { Text(text = "CPF")},
            placeholder = { Text(text = "Enter your CPF")}
        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { mainViewModel?.validate() }) {
            Text(text = "VALIDATE")
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    NappTheme {
        MainScreen(mainViewModel = null)
    }
}
