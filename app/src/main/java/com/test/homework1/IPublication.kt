package com.test.homework1

interface IPublication {
    val price: Double
    val wordCount: Int

    fun getType(): String
}