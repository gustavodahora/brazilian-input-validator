package dev.gustavodahora.br_input_validation

import org.junit.Assert.*
import org.junit.Test

class ValidateInputTest {
    /*
    Util Validate Section
     */
    @Test
    fun `clear input string`() {
        val expected = CLEAR_NUM

        assertEquals(expected, ValidateInput.clean("111.111.111-11"))
        assertEquals(expected, ValidateInput.clean("111.111.111-11"))
    }

    /*
    CPF Section
     */
    @Test
    fun `if valid CPF is valid`() {
        assertTrue(ValidateInput.cpf(VALID_CPF))
    }
    @Test
    fun `if invalid CPF is invalid`() {
        assertFalse(ValidateInput.cpf(INVALID_CPF))
    }

    /*
    CNPJ Section
     */
    @Test
    fun `if valid CNPJ is valid`() {
        assertTrue(ValidateInput.cnpj(VALID_CNPJ))
    }
    @Test
    fun `if invalid CNPJ is invalid`() {
        assertFalse(ValidateInput.cnpj(INVALID_CNPJ))
    }

    companion object {
        const val CLEAR_NUM = "11111111111"

        const val INVALID_CPF = "111.111.111-11"
        const val VALID_CPF = "757.697.100-20"
        const val INVALID_CNPJ = "37.764.222/9284-14"
        const val VALID_CNPJ = "37.764.307/9284-14"
    }
}