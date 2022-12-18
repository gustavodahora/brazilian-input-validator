package dev.gustavodahora.napp.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gustavodahora.napp.R
import dev.gustavodahora.napp.ui.theme.BackgroundNeutral
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.ui.theme.TextNeutral
import dev.gustavodahora.napp.ui.theme.Typography
import dev.gustavodahora.napp.view.composable.component.ValidatorField
import dev.gustavodahora.napp.view.viewModel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel?
) {

    val state = mainViewModel?.state

    state?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
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
            ValidatorField(
                modifier = Modifier.fillMaxWidth(),
                value = mainViewModel.textCpf,
                onValueChange = { text ->
                    mainViewModel.textCpf = text
                },
                label = { Text(text = stringResource(id = R.string.cpf)) },
                placeholder = { Text(text = stringResource(id = R.string.tf_cpf_placeholder)) },
                fieldStatus = state.value.cpf
            )
            Spacer(modifier = Modifier.size(10.dp))
            ValidatorField(
                modifier = Modifier.fillMaxWidth(),
                value = mainViewModel.textCnpj,
                onValueChange = { text ->
                    mainViewModel.textCnpj = text
                },
                label = { Text(text = stringResource(id = R.string.cnpj)) },
                placeholder = { Text(text = stringResource(id = R.string.tf_cnpj_placeholder)) },
                fieldStatus = state.value.cnpj
            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { mainViewModel.validate() }) {
                Text(text = stringResource(id = R.string.validate))
            }
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
