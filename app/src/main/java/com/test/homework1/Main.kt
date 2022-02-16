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

fun User.ageCheck() {
    if (this.age < 19) {
        throw Exception("Error!!!! \n Пользователь ${this.name} по id(${this.id}) не старше 18 лет(${this.age})")
    }
}

val authCallback = object : AuthCallback{
    override fun authSuccess() {
        println("Пользователь успешно авторизован!")
    }

    override fun authFailed() {
        println("Пользователь не прошел авторизацию!")
    }
}

fun updateCache(cacheCheckUpd: Boolean){
    if(cacheCheckUpd){
        println("Кэш обновлен!\n")
    }else{
        println("Кэш не был обновлен!\n")
    }
}

inline fun auth(updateCache: (Boolean) -> Unit , user: User){
    try{
        user.ageCheck()
        authCallback.authSuccess()
        updateCache(true)
    }
    catch(ex: Exception){
        authCallback.authFailed()
        updateCache(false)
        throw ex
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
    users.forEach {
        println(" $it")
    }

    println("\nСписок пользователей, имеющих полный доступ:\n")
    users.filter { it.type == Type.FULL }
        .forEach {
            println(" $it")
        }

    val nameUsers = users.map { rec -> rec.name }
    println("\nСписок имён пользователей: \n")
    nameUsers.forEach {
        println(" $it")
    }
    println("\nПервый пользователь: ${nameUsers.firstOrNull()};\n")
    println("Последний пользователь: ${nameUsers.lastOrNull()}.\n")

    Registration().doAction()
    Login(user1).doAction()
    //Login(users[3]).doAction()
    Logout().doAction()
}