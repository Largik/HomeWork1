package com.test.homework1

open class Magazine(override val price: Double, override val wordCount: Int): AbstractPublication() {
    override fun getType(): String {
        return "Magazine"
    }
}