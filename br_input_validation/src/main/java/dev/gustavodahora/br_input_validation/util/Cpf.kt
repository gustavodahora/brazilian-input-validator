package dev.gustavodahora.br_input_validation.util


class Cpf {
    companion object {
        private var MAX_CPF_LENGTH = 11

        fun isIncorrectLength(input: String): Boolean {
            return input.length != MAX_CPF_LENGTH
        }
    }
}