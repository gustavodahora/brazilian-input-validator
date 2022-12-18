package dev.gustavodahora.napp.view.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.gustavodahora.br_input_validation.ValidateInput
import dev.gustavodahora.napp.view.model.FieldState
import dev.gustavodahora.napp.view.model.FieldStatus
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var validateJob: Job = Job()

    var textCnpj by mutableStateOf(TextFieldValue(text = EMPTY_TEXT))
    var textCpf by mutableStateOf(TextFieldValue(text = EMPTY_TEXT))

    var state = mutableStateOf(FieldState())

    fun validate() {
        validateJob.cancel()
        validateJob = viewModelScope.launch {
            when (ValidateInput.cnpj(textCnpj.text)) {
                true -> {
                    state.value = state.value.copy(cnpj = FieldStatus.VALID)
                }
                false -> {
                    state.value = state.value.copy(cnpj = FieldStatus.ERROR)
                }
            }
        }
    }

    companion object {
        const val EMPTY_TEXT = ""
    }
}
