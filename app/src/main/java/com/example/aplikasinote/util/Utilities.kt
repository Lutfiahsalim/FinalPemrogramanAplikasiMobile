package com.example.aplikasinote.util

import android.text.Editable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utilities {
    fun LocalDate.formatToString(): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLL")
        return this.format(dateTimeFormatter)
    }

    fun String.formatToDate(): String {
        val localDate = LocalDate.parse(this)
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLL")
        return localDate.format(dateTimeFormatter)
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}