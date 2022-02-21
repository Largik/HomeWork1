package com.test.homework1

sealed class Action{
    object Registration : Action()
    class Login(val user: User) : Action()
    object Logout : Action()
}

fun doAction(action: Action) {
    when (action) {
        is Action.Registration ->  println("Регистрация прошла успешно!\n")
        is Action.Login -> {
            println("Auth has started.")
            auth(::updateCache, action.user)
        }
        is Action.Logout -> println("Пользователь вышел!\n")
    }
}