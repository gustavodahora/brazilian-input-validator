package dev.gustavodahora.br_input_validation.util

class Cnpj {
    companion object {
        private const val MAX_CNPJ_LENGTH = 14

        fun isNotCorrectLength(cnpj: String): Boolean {
            return cnpj.length > MAX_CNPJ_LENGTH
        }
    }
}