package dev.gustavodahora.br_input_validation.util

import org.junit.Assert
import org.junit.Test

class CpfUtilTest {
    @Test
    fun `if length is incorrect`() {
        Assert.assertTrue(Cpf.isIncorrectLength("333.333.333-333".justNumbers()))
        Assert.assertFalse(Cpf.isIncorrectLength("333.333.333-33".justNumbers()))
    }
}