package com.example.lessonsFromSamsung

private fun main() {
    // Если у лямбды есть параметры, то они указываются перед знаком '->'
    // После '->' могут быть выполнены какие-то действия
    // Последнее выражение в лямбде считается возвращаемым значением:
    val sum = { x: Int, y: Int -> x + y }
    // то же, что и:
    val sum1: (Int, Int) -> Int = { x, y -> x + y }

    //анонимная функция
    fun(x: Int, y: Int): Int = x + y
/*
Функция max является функцией высшего порядка, потому что она принимает функцию в качестве второго аргумента:
max(strings, { a, b -> a.length < b.length })

Лямбда здесь - то же самое, что и:
fun compare(a: String, b: String): Boolean = a.length < b.length
 */

    lock(2) {
        println(it)
    }
}
// Из-за слова Inline не создается класс для лямбды и при компиляции содержимое функции появляется в месте вызова
inline fun lock(arg: Int, body: (Int) -> Unit) {
    body.invoke(arg * 2)
}

