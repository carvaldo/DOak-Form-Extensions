package com.github.carvaldo.doakFormExtensions

import android.app.DatePickerDialog
import android.util.Patterns
import android.view.KeyEvent
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

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

fun TextInputEditText.isValidDate(pattern: String, message: String? = null): Boolean {
    TODO("Implementar validador de data através de um parse")
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

// TODO: Criar um Builder para Config do input de data.
//    Conter:
//        * Dia mínimo
//        * Dia máximo
//        * Date Pattern
//        * Locale
//        * Pick inicial
fun EditText.enableDateDialog(pattern: String? = null) {
    val dateFormat = if (pattern != null) SimpleDateFormat(pattern) else SimpleDateFormat()
    this.setOnTouchListener { v, event ->
        if (event.action == KeyEvent.ACTION_UP) {
            v.performClick()
            showDateDialog(dateFormat)
        }
        return@setOnTouchListener true
    }
}

fun EditText.disableDateDialog() {
    this.setOnTouchListener { _, _ -> return@setOnTouchListener false }
}

private fun EditText.showDateDialog(dateFormat: SimpleDateFormat) {
    val calendar = Calendar.getInstance(Locale.getDefault())
    DatePickerDialog(this.context, { _, year, month, dayOfMonth ->
        calendar.set(year, month, dayOfMonth)
        this@showDateDialog.setText(dateFormat.format(calendar.time))
    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
}