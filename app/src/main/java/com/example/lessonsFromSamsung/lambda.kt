package com.example.lessonsFromSamsung

private fun main(
    // Если у лямбды есть параметры, то они указываются перед знаком '->'
    combine: (a: Int, b: String) ->
    // После '->' могут быть выполнены какие-то действия
    // Some code...
    // Последнее выражение в лямбде считается возвращаемым значением:
    R
): R {
    val c = combine(1, "element")
    return c
}