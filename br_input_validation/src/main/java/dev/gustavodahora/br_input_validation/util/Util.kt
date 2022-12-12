package dev.gustavodahora.br_input_validation.util

fun String.justNumbers() : String{
    return this.replace("\\D".toRegex(), "")
}