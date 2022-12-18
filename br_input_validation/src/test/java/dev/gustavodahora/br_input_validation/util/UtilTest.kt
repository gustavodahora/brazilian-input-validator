package dev.gustavodahora.br_input_validation.util

import org.junit.Assert
import org.junit.Test

class UtilTest {
    @Test
    fun `if all letters are same`() {
        Assert.assertTrue("333.333.333-33".justNumbers().allCharactersSame())
        Assert.assertFalse("123.456.789-00".justNumbers().allCharactersSame())
    }
}