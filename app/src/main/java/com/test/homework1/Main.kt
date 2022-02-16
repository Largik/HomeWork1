package com.test.homework1

import kotlin.math.roundToInt
import kotlin.random.Random

fun buy(publication: IPublication?) {
    publication?.let{
        val price = publication.price * 100.0
        println("The purchase is complete. The purchase amount was ${price.roundToInt() / 100.0}\n")
    }
}

fun main(){
    val book1 = Book(Random.nextDouble( 10.01, 5000.01), Random.nextInt(50, 14000))
    book1.formattedPrint()

    val book2 = Book(Random.nextDouble( 10.01, 5000.01), Random.nextInt(50, 14000))
    book2.formattedPrint()

    val magazine = Magazine(Random.nextDouble( 10.01, 500.01), Random.nextInt(50, 1400))
    magazine.formattedPrint()

    book1.equals(book2)
    book1.equals(book1)

    val bookNull: Book? = null
    buy(book1)
    buy(bookNull)

    val sum = { x: Int, y: Int -> x + y}
    val x = Random.nextInt(1, 1000)
    val y = Random.nextInt(1, 1000)
    println("Сумма произвольных чисел $x и $y: ${sum(x, y)}")
}
