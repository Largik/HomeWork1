package com.test.homework1

import java.lang.Exception

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
        println("Кэш обновлен!")
    }else{
        println("Кэш не был обновлен!")
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