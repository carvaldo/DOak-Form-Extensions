package com.github.carvaldo.doakFormExtensions

import android.util.Patterns
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.isValidEmail(message: String? = null): Boolean {
    return if (!this.text.toString().matches(Patterns.EMAIL_ADDRESS.toRegex())) {
        error = message ?: "Insira um email válido."
        false
    } else {
        error = null
        true
    }
}

fun TextInputEditText.isEmpty(message: String? = null): Boolean {
    return if (this.text.toString().isEmpty()) {
        error = message ?: "Informação obrigatória."
        true
    } else {
        error = null
        false
    }
}

fun TextInputEditText.hasMinCharacters(length: Int, msgError: String? = null): Boolean {
    return if (this.text.toString().length < length) {
        error = msgError ?: "É necessário ao menos $length caracteres"
        false
    } else {
        error = null
        true
    }
}

fun TextInputEditText.contentEquals(other: TextInputEditText, message: String? = null): Boolean {
    return  if (text.toString() == other.text.toString()) {
        error = null
        true
    } else {
        error = message?: "As senhas informadas não são correspondentes."
        false
    }
}
