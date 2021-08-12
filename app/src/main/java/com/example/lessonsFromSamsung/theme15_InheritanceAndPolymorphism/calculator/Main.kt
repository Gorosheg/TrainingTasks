package com.example.lessonsFromSamsung.theme15_InheritanceAndPolymorphism.calculator

import java.util.*

private val inScanner = Scanner(System.`in`)

private fun main() {
    val calculator = Calculator()
    calculator.initialGreeting()
    calculator.variantsOfOperations()

    when (inScanner.nextInt()) {
        1 -> plusNumbers()
        2 -> minusNumbers()
        3 -> multiplyNumbers()
        4 -> splitNumbers()
    }
}

fun plusNumbers() {
    Addition().askToEnterNumbers()
    val a = inScanner.nextInt()
    val b = inScanner.nextInt()
    println(Addition().add(a, b))
}

fun minusNumbers() {
    Subtraction().askToEnterNumbers()
    val a = inScanner.nextInt()
    val b = inScanner.nextInt()
    println(Subtraction().minus(a, b))
}

fun multiplyNumbers() {
    Multiplication().askToEnterNumbers()
    val a = inScanner.nextInt()
    val b = inScanner.nextInt()
    println(Multiplication().multiplication(a, b))
}

fun splitNumbers() {
    Division().askToEnterNumbers()
    val a = inScanner.nextInt()
    val b = inScanner.nextInt()
    println(Division().division(a, b))
}
