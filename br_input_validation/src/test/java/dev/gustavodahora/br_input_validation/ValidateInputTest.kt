package dev.gustavodahora.br_input_validation

import org.junit.Assert.*
import org.junit.Test

class ValidateInputTest {
    @Test
    fun `if valid CPF is valid`() {
        assertTrue(ValidateInput.cpf("757.697.100-20"))
    }
    @Test
    fun `if invalid CPF is invalid`() {
        assertFalse(ValidateInput.cpf("111.111.111-11"))
    }
    @Test
    fun `clear input string`() {
        val expected = CLEAR_NUM

        assertEquals(expected, ValidateInput.clean("111.111.111-11"))
        assertEquals(expected, ValidateInput.clean("111.111.111-11"))
    }

    companion object {
        const val CLEAR_NUM = "11111111111"
    }
}