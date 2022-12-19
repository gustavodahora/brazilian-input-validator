package dev.gustavodahora.napp.view.model

data class FieldState(
    var cnpj: FieldStatus = FieldStatus.IDLE,
    var cpf: FieldStatus = FieldStatus.IDLE,
)

enum class FieldStatus {
    VALID, ERROR, IDLE
}