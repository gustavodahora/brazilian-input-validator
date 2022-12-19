package dev.gustavodahora.br_input_validation

import dev.gustavodahora.br_input_validation.util.Cnpj
import dev.gustavodahora.br_input_validation.util.Cpf
import dev.gustavodahora.br_input_validation.util.allCharactersSame
import dev.gustavodahora.br_input_validation.util.justNumbers
import java.util.*

class ValidateInput {
    companion object {
        fun clean(input: String): String {
            return input
                .trim()
                .justNumbers()
                .replace(".", "")
                .replace("-", "")
                .replace("/", "")
        }

        fun cpf(cpf: String): Boolean {
            val nCpf = clean(input = cpf)
            try {
                if (nCpf.allCharactersSame()) return false
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
                    dig10 = if (r == 10 || r == 11) '0'
                    else (r + 48).toChar() // Converts respective number char

                    // Calculate second validator number
                    sm = 0
                    peso = 11
                    i = 0
                    while (i < 10) {
                        num = nCpf[i].code - 48
                        sm += num * peso
                        peso -= 1
                        i++
                    }

                    r = 11 - sm % 11
                    dig11 = if (r == 10 || r == 11) '0'
                    else (r + 48).toChar()

                    // Validate if all digits calculated agree with informed digits.
                    return dig10 == nCpf[9] && dig11 == nCpf[10]
                } catch (e: InputMismatchException) {
                    return false
                }
            } catch (e: Exception) {
                return false
            }
        }

        fun cnpj(input: String): Boolean {
            val cnpj = clean(input)

            try {
                cnpj.toLong()
            } catch (e: NumberFormatException) {
                return false
            }

            if (cnpj.allCharactersSame()) return false
            if (Cnpj.isNotCorrectLength(cnpj)) return false

            val dig13: Char
            val dig14: Char
            var sm: Int
            var i: Int
            var r: Int
            var num: Int
            var weight: Int

            return try {
                sm = 0
                weight = 2
                i = 11
                while (i >= 0) {
                    num = (cnpj[i].code - 48)
                    sm += num * weight
                    weight += 1
                    if (weight == 10) weight = 2
                    i--
                }
                r = sm % 11
                dig13 = if (r == 0 || r == 1) '0' else (11 - r + 48).toChar()

                sm = 0
                weight = 2
                i = 12
                while (i >= 0) {
                    num = (cnpj[i].code - 48)
                    sm += num * weight
                    weight += 1
                    if (weight == 10) weight = 2
                    i--
                }
                r = sm % 11
                dig14 = if (r == 0 || r == 1) '0' else (11 - r + 48).toChar()
                dig13 == cnpj[12] && dig14 == cnpj[13]
            } catch (e: Exception) {
                false
            }
        }

        // TODO PIX_RANDOM_KEY
    }
}