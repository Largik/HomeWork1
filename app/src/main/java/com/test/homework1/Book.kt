package com.test.homework1

open class Book (override val price: Double, override val wordCount: Int): AbstractPublication(){
    override fun getType(): String {
        return when (wordCount) {
            in 1..1000 -> "Flash Fiction"
            in 1001..7500 -> "Short Story"
            else -> "Novel"
        }
    }

    override fun equals(other: Any?): Boolean {
        println("Результаты сравнения ссылок:\n" +
                "Сравнение по ссылке \"===\": ${this === other};\n" +
                "Сравнение методом equals(): ${super.equals(other)}.\n")

        return super.equals(other)
    }
}