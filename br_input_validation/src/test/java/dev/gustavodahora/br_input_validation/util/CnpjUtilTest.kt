package dev.gustavodahora.br_input_validation.util

import org.junit.Assert
import org.junit.Test

class CnpjUtilTest {
    @Test
    fun `if length is incorrect`() {
        Assert.assertFalse(Cnpj.isNotCorrectLength("37.764.307/9284-14".justNumbers()))
        Assert.assertTrue(Cnpj.isNotCorrectLength("32.222.30722/9284-14".justNumbers()))
    }
}