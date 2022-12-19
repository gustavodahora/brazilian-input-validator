package dev.gustavodahora.napp.view.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gustavodahora.napp.R
import dev.gustavodahora.napp.ui.theme.BackgroundNeutral
import dev.gustavodahora.napp.ui.theme.NappTheme
import dev.gustavodahora.napp.ui.theme.SuccessDefault
import dev.gustavodahora.napp.view.model.FieldStatus

@Composable
fun ValidatorField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: @Composable (() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    fieldStatus: FieldStatus,
) {
    var isError = false
    var isValid = false

    when (fieldStatus) {
        FieldStatus.VALID -> {
            isValid = true
        }
        FieldStatus.ERROR -> {
            isError = true
        }
        FieldStatus.IDLE -> {}
    }

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        isError = isError,
        trailingIcon = {
            if (isValid) Icon(
                imageVector = Icons.Default.Done,
                contentDescription = null,
                tint = SuccessDefault
            )
        }
    )
}

@Preview
@Composable
private fun PreviewMTextField() {
    var textCnpj by remember { mutableStateOf(TextFieldValue(text = "")) }

    NappTheme{
        Column(
            modifier = Modifier
                .background(BackgroundNeutral)
                .padding(8.dp)
        ) {
            // Valid
            ValidatorField(
                value = textCnpj,
                onValueChange = { text ->
                    textCnpj = text
                },
                label = { Text(text = stringResource(id = R.string.cpf)) },
                placeholder = { Text(text = stringResource(id = R.string.tf_cpf_placeholder)) },
                fieldStatus = FieldStatus.VALID,
            )
            Spacer(Modifier.size(8.dp))
            // Invalid
            ValidatorField(
                value = textCnpj,
                onValueChange = { text ->
                    textCnpj = text
                },
                label = { Text(text = stringResource(id = R.string.cnpj)) },
                placeholder = { Text(text = stringResource(id = R.string.tf_cnpj_placeholder)) },
                fieldStatus = FieldStatus.ERROR
            )
            Spacer(Modifier.size(8.dp))
            // Idle
            ValidatorField(
                value = textCnpj,
                onValueChange = { text ->
                    textCnpj = text
                },
                label = { Text(text = stringResource(id = R.string.random_pix)) },
                placeholder = { Text(text = stringResource(id = R.string.tf_random_pix_placeholder)) },
                fieldStatus = FieldStatus.IDLE
            )
        }
    }
}