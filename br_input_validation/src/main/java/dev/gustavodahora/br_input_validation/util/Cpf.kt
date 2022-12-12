package dev.gustavodahora.br_input_validation.util


class Cpf {
    companion object {
        fun allCharactersSame(input: String): Boolean {
            if (input.isEmpty()) return true
            for (i in input) {
                if (i != input[INITIAL_STRING_INDEX]) {
                    return false
                }
            }
            return true
        }
        fun isIncorrectLength(input: String): Boolean {
            return input.length != MAX_CPF_LENGTH
        }
        var MAX_CPF_LENGTH = 11
        var INITIAL_STRING_INDEX = 0
    }
}