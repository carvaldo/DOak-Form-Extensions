package com.github.carvaldo.doak

import android.graphics.Paint
import android.widget.TextView

fun TextView.paintUnderline() {
    this.paintFlags = Paint.UNDERLINE_TEXT_FLAG
}