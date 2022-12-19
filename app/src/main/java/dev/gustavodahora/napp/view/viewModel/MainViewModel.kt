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
import dev.gustavodahora.napp.view.model.FieldToValidate
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var cnpjJob: Job = Job()
    private var cpfJob: Job = Job()

    var textCnpj by mutableStateOf(TextFieldValue(text = EMPTY_TEXT))
    var textCpf by mutableStateOf(TextFieldValue(text = EMPTY_TEXT))

    var state = mutableStateOf(FieldState())

    var fieldToValidate = FieldToValidate()

    private fun validateAfterField() {
        fieldToValidate.apply {
            cpfJob.cancel()
            cpf?.let {
                cpfJob = viewModelScope.launch {
                    when (ValidateInput.cpf(textCpf.text)) {
                        true -> {
                            state.value = state.value.copy(cpf = FieldStatus.VALID)
                        }
                        false -> {
                            state.value = state.value.copy(cpf = FieldStatus.ERROR)
                        }
                    }
                }
            }
            cnpjJob.cancel()
            cnpj?.let {
                cnpjJob = viewModelScope.launch {
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
        }
    }

    fun startValidation() {
        setupFieldsToValidate()
        validateAfterField()
    }

    fun setupFieldsToValidate() {
        fieldToValidate = FieldToValidate()
        if (textCpf.text.isNotEmpty()) fieldToValidate.cpf = true
        if (textCnpj.text.isNotEmpty()) fieldToValidate.cnpj = true
    }

    companion object {
        const val EMPTY_TEXT = ""
    }
}
