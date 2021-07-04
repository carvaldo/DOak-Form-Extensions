package com.github.carvaldo.doakFormExtensions

import android.text.Editable
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.charset.Charset
fun Editable?.toInt(): Int? = if (!this.isNullOrEmpty()) this.toString().toInt() else null

fun Editable?.toDouble(): Double? = if (!this.isNullOrEmpty()) this.toString().toDouble() else null

fun Editable?.toFloat(): Float? = if (!this.isNullOrEmpty()) this.toString().toFloat() else null

fun Editable?.toLong(): Long? = if (!this.isNullOrEmpty()) this.toString().toLong() else null

fun Editable?.toBoolean(): Boolean? = if (!this.isNullOrEmpty()) this.toString().toBoolean() else null

fun Editable?.toCharArray(): CharArray? = if (!this.isNullOrEmpty()) this.toString().toCharArray() else null

fun Editable?.toByte(): Byte? = if (!this.isNullOrEmpty()) this.toString().toByte() else null

fun Editable?.toInt(charset: Charset): ByteArray? = if (!this.isNullOrEmpty()) this.toString().toByteArray(charset) else null

fun Editable?.toBigInteger(): BigInteger? = if (!this.isNullOrEmpty()) this.toString().toBigInteger() else null

fun Editable?.toBigDecimal(): BigDecimal? = if (!this.isNullOrEmpty()) this.toString().toBigDecimal() else null

fun Editable?.toShort(): Short? = if (!this.isNullOrEmpty()) this.toString().toShort() else null