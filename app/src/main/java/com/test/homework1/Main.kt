package com.test.homework1

import java.lang.Exception
import kotlin.math.roundToInt
import kotlin.random.Random

fun buy(publication: IPublication?) {
    publication?.let {
        val price = publication.price * 100.0
        println("The purchase is complete. The purchase amount was ${price.roundToInt() / 100.0}\n")
    }
}

fun User.ageCheck(){
    if(this.age < 19){
        throw Exception("Error!!!! \n Пользователь ${this.name} по id(${this.id}) не старше 18 лет(${this.age})")
    }
}

fun main() {
    val book1 = Book(Random.nextDouble(10.01, 5000.01), Random.nextInt(50, 14000))
    book1.formattedPrint()

    val book2 = Book(Random.nextDouble(10.01, 5000.01), Random.nextInt(50, 14000))
    book2.formattedPrint()

    val magazine = Magazine(Random.nextDouble(10.01, 500.01), Random.nextInt(50, 1400))
    magazine.formattedPrint()

    book1.equals(book2)
    book1.equals(book1)

    val bookNull: Book? = null
    buy(book1)
    buy(bookNull)

    val sum = { x: Int, y: Int -> x + y }
    val x = Random.nextInt(1, 1000)
    val y = Random.nextInt(1, 1000)
    println("Сумма произвольных чисел $x и $y: ${sum(x, y)}\n")

    val user1 = User(1, "first user", 20, Type.FULL)
    println("Создан пользователь: ${user1.startTime}")
    Thread.sleep(1000)
    println("После ожидания: ${user1.startTime}\n")

    val users = mutableListOf(user1)
    users.apply {
        this.add(
            User(2, "second user", 17, Type.DEMO)
        )
        this.add(
            User(3, "third user", 21, Type.FULL)
        )
        this.add(
            User(4, "fourth user", 15, Type.DEMO)
        )
    }
    println("Список пользователей: \n")
    users.forEach{
        auth(::updateCache, it)
        println(" $it\n")
    }

    println(" Список пользователей, имеющих полный доступ:\n")
    users.filter { it.type == Type.FULL }
        .forEach {
            println(" $it\n")
        }

    val nameUsers = users.map{ rec -> rec.name }
    println("Список имён пользователей: \n")
    nameUsers.forEach{
        println(" $it\n")
    }
    println("Первый пользователь: ${nameUsers.firstOrNull()};\n")
    println("Последний пользователь: ${nameUsers.lastOrNull()}.\n")
}