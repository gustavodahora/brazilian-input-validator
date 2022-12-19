package dev.gustavodahora.br_input_validation.util

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import dev.gustavodahora.napp.view.model.FieldState
import dev.gustavodahora.napp.view.model.FieldStatus
import dev.gustavodahora.napp.view.model.FieldToValidate
import dev.gustavodahora.napp.view.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        mainViewModel = MainViewModel()
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `field status CPF valid change after complete`() {
        val expectedState = mutableStateOf(FieldState())
        expectedState.value = expectedState.value.copy(cpf = FieldStatus.VALID)

        mainViewModel.textCpf = TextFieldValue(text = VALID_CPF)
        mainViewModel.startValidation()

        assertEquals(expectedState.value, mainViewModel.state.value)
    }

    @Test
    fun `field status CPF invalid change after complete`() {
        val expectedState = mutableStateOf(FieldState())
        expectedState.value = expectedState.value.copy(cpf = FieldStatus.ERROR)

        mainViewModel.textCpf = TextFieldValue(text = INVALID_CPF)
        mainViewModel.startValidation()

        assertEquals(expectedState.value, mainViewModel.state.value)
    }

    @Test
    fun `field status CNPJ valid change after complete`() {
        val expectedState = mutableStateOf(FieldState())
        expectedState.value = expectedState.value.copy(cnpj = FieldStatus.VALID)

        mainViewModel.textCnpj = TextFieldValue(text = VALID_CNPJ)
        mainViewModel.startValidation()

        assertEquals(expectedState.value, mainViewModel.state.value)
    }

    @Test
    fun `field status CNPJ invalid change after complete`() {
        val expectedState = mutableStateOf(FieldState())
        expectedState.value = expectedState.value.copy(cnpj = FieldStatus.ERROR)

        mainViewModel.textCnpj = TextFieldValue(text = INVALID_CNPJ)
        mainViewModel.startValidation()

        assertEquals(expectedState.value, mainViewModel.state.value)
    }

    @Test
    fun `assert only filled fields will be validated`() {
        mainViewModel.textCpf = TextFieldValue(text = VALID_CNPJ)
        mainViewModel.textCnpj = TextFieldValue(text = EMPTY_FIELD)

        mainViewModel.setupFieldsToValidate()

        val expected = FieldToValidate(cpf = true, cnpj = null)

        assertEquals(expected, mainViewModel.fieldToValidate)
    }

    companion object {
        const val EMPTY_FIELD = ""

        const val INVALID_CPF = "111.111.111-11"
        const val VALID_CPF = "757.697.100-20"
        const val INVALID_CNPJ = "37.764.222/9284-14"
        const val VALID_CNPJ = "37.764.307/9284-14"
    }
}