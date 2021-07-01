package com.github.carvaldo.doakFormExtensions.view

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.text.InputType
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import com.github.carvaldo.doakFormExtensions.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Custom View para criar um campo de entrada do tipo data.
 *
 * @see pattern Padrão para formatação da data.
 */
class DateInputView : AppCompatEditText {
    private lateinit var dateFormat: DateFormat
    private lateinit var calendar: Calendar
    private var pattern: String? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }


    /**
     * Converte o conteúdo da view em uma instância de Date.
     *
     * @return Date
     */
    fun toDate(): Date? = dateFormat.parse(this.text.toString())

    /**
     * Converte o conteúdo da view em uma String.
     *
     * @return String
     */
    override fun toString(): String = this.text?.toString() ?: ""

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.DateInputView, defStyle, 0
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setRawInputType(InputType.TYPE_DATETIME_VARIATION_DATE)
        } else {
            inputType = InputType.TYPE_DATETIME_VARIATION_DATE
        }
        maxLines = 1
        pattern = a.getString(R.styleable.DateInputView_pattern)
        calendar = Calendar.getInstance(Locale.getDefault())
        dateFormat = if (pattern != null) {
            SimpleDateFormat(pattern, Locale.getDefault())
        } else {
            SimpleDateFormat(null, Locale.getDefault())
        }
        enableDateDialog()
        a.recycle()
    }

    private fun enableDateDialog() {
        this.setOnTouchListener { v, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                v.performClick()
                showDateDialog()
            }
            return@setOnTouchListener true
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun showDateDialog() {
        DatePickerDialog(this.context, { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            this.setText(dateFormat.format(calendar.time))
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
}