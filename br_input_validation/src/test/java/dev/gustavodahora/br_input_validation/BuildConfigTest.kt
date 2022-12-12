package dev.gustavodahora.br_input_validation

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BuildConfigTest {
    @Test
    fun `expected build config`() {
        if (BuildConfig.DEBUG) {
            assertTrue(BuildConfig.DEBUG)
            assertEquals(BUILD_TYPE, BuildConfig.BUILD_TYPE)
        }
        assertEquals(LIBRARY_PACKAGE_NAME, BuildConfig.LIBRARY_PACKAGE_NAME)
    }

    companion object {
        const val LIBRARY_PACKAGE_NAME = "dev.gustavodahora.br_input_validation"
        const val BUILD_TYPE = "debug"
    }
}