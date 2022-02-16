package com.test.homework1

open class Book (override val price: Double, override val wordCount: Int): AbstractPublication(){
    override fun getType(): String {
        var result = "Novel"

        if( this.wordCount < 1001){
            result = "Flash Fiction"
        }else if(this.wordCount < 7501){
            result = "Short Story"
        }

        return result
    }

    override fun equals(other: Any?): Boolean {
        println("Результаты сравнения ссылок:\n" +
                "Сравнение по ссылке \"===\": ${this === other};\n" +
                "Сравнение методом equals(): ${super.equals(other)}.\n")

        return super.equals(other)
    }
}