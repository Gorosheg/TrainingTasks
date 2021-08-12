package com.example.lessonsFromSamsung.theme22_InputOutputExceptions

private fun main() {
    divideNumbers()
}

private fun divideNumbers() {
    try {
        divideNumbersUnsafety()
    } catch (exception: Exception) {
        println("Недопустимая арифметическая операция")
    }
}

private fun divideNumbersUnsafety() {
    val a = 90
    val b = 0

    if (b == 0) {
        val exception = Exception()
        throw exception
    }

    println(a / b)
}