package dev.gustavodahora.br_input_validation.util

import dev.gustavodahora.br_input_validation.justNumbers
import org.junit.Assert
import org.junit.Test

class CpfUtilTest {
    @Test
    fun `if all CPF are same`() {
        Assert.assertTrue(Cpf.allCharactersSame("333.333.333-33".justNumbers()))
        Assert.assertFalse(Cpf.allCharactersSame("123.456.789-00".justNumbers()))
    }
    @Test
    fun `if length is incorrect`() {
        Assert.assertTrue(Cpf.isIncorrectLength("333.333.333-333".justNumbers()))
        Assert.assertFalse(Cpf.isIncorrectLength("333.333.333-33".justNumbers()))
    }
}