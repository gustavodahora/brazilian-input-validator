package dev.gustavodahora.br_input_validation.util

fun String.justNumbers() : String{
    return this.replace("\\D".toRegex(), "")
}

fun String.allCharactersSame(): Boolean {
    val initialLengthString = 0

    if (this.isEmpty()) return true
    for (i in this) {
        if (i != this[initialLengthString]) {
            return false
        }
    }
    return true
}