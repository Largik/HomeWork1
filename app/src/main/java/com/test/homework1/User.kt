package com.test.homework1

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val type: Type
){
    val startTime: String by lazy {
        val timeFormat: DateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        timeFormat.format(Date())
    }
}
