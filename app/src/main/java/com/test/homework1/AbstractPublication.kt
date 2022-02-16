package com.test.homework1

import kotlin.math.roundToInt

abstract class AbstractPublication(): IPublication {
    fun formattedPrint(){
       println("-----------------------------------\n" +
               "Тип: ${getType()}; \n" +
               "Количество слов: $wordCount; \n" +
               "Цена: ${(price * 100.0).roundToInt() / 100.0} руб. \n" +
               "-----------------------------------\n")
    }
}