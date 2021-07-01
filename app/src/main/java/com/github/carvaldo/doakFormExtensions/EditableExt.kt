package com.github.carvaldo.doakFormExtensions

import android.text.Editable
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.charset.Charset

fun Editable?.toInt(): Int? = this?.toString()?.toInt()

fun Editable?.toDouble(): Double? = this?.toString()?.toDouble()

fun Editable?.toFloat(): Float? = this?.toString()?.toFloat()

fun Editable?.toLong(): Long? = this?.toString()?.toLong()

fun Editable?.toBoolean(): Boolean? = this?.toString()?.toBoolean()

fun Editable?.toCharArray(): CharArray? = this?.toString()?.toCharArray()

fun Editable?.toByte(): Byte? = this?.toString()?.toByte()

fun Editable?.toInt(charset: Charset): ByteArray? = this?.toString()?.toByteArray(charset)

fun Editable?.toBigInteger(): BigInteger? = this?.toString()?.toBigInteger()

fun Editable?.toBigDecimal(): BigDecimal? = this?.toString()?.toBigDecimal()

fun Editable?.toShort(): Short? = this?.toString()?.toShort()