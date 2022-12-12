package dev.gustavodahora.br_input_validation

import dev.gustavodahora.br_input_validation.util.Cpf
import dev.gustavodahora.br_input_validation.util.justNumbers
import java.util.*

class ValidateInput {
    companion object {
        private fun clean(input: String): String {
            return input.trim().justNumbers().replace(".", "").replace("-", "")
        }

        fun cpf(cpf: String): Boolean {
            val nCpf = clean(input = cpf)
            try {
                if (Cpf.allCharactersSame(input = nCpf)) return false
                if (Cpf.isIncorrectLength(input = nCpf)) return false

                val dig10: Char
                val dig11: Char
                var sm: Int
                var i: Int
                var r: Int
                var num: Int
                var peso: Int

                try {
                    // Calculate first digit
                    sm = 0
                    peso = 10
                    i = 0
                    while (i < 9) {
                        num = nCpf[i].code - 48
                        sm += num * peso
                        peso -= 1
                        i++
                    }

                    r = 11 - sm % 11
                    if (r == 10 || r == 11) dig10 = '0'
                    else dig10 = (r + 48).toChar() // Converts respective number char

                    // Calculate second validator number
                    sm = 0
                    peso = 11
                    i = 0
                    while (i < 10) {
                        num = nCpf[i].toInt() - 48
                        sm += num * peso
                        peso -= 1
                        i++
                    }

                    r = 11 - sm % 11
                    dig11 = if (r == 10 || r == 11) '0'
                    else (r + 48).toChar()

                    // Validate if all digits calculated agree with informed digits.
                    return dig10 == nCpf[9] && dig11 == nCpf[10]
                } catch (error: InputMismatchException) {
                    return false
                }
            } catch (e: Exception) {
                return false
            }
        }

        // TODO CNPJ
        // TODO CPF
        // TODO PIX_RANDOM_KEY
    }
}