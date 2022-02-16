package com.test.homework1

open class Login(private val user: User): Action() {
    override fun doAction() {
        auth(::updateCache, user)
    }
}