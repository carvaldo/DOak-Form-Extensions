package com.github.carvaldo.doakFormExtensions.view

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher
import com.github.carvaldo.doakFormExtensions.R

open class MaskInputView : AppCompatEditText {
    var mask: String? = null
        set(value) {
            field = value
            invalidateMask()
        }
    private var textWatcher: TextWatcher? = null

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

    override fun toString() = text?.toString() ?: ""

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.MaskInputView, defStyle, 0
        )
        mask = a.getString(
            R.styleable.MaskInputView_mask
        )
        a.recycle()
    }

    private fun invalidateMask() {
        if (textWatcher != null) {
            this.removeTextChangedListener(textWatcher)
        }
        if (mask != null) {
            textWatcher = MascaraNumericaTextWatcher(mask)
            this.addTextChangedListener(textWatcher)
        }
    }
}