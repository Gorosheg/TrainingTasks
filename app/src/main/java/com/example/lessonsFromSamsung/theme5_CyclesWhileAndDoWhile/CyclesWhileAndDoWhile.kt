package com.example.lessonsFromSamsung.theme5_CyclesWhileAndDoWhile

import com.example.lessonsFromSamsung.utils.scanner
import kotlin.math.absoluteValue
import kotlin.math.pow

private fun main() {
    work112214()
}

// Четные натуральные числа
fun work5ex1() {
    val n = scanner.nextInt()
    var i = 0

    while (i / 2 < n) {
        i++
        if (i % 2 != 0) continue
        println(i)
    }
}

// Вывести, сколько чисел до нуля
fun work3064() {
    var amount = 0

    do {
        val n = scanner.nextInt()
        amount++
    } while (n > 0)

    println(amount - 1)
}

// Найти все целые решения уравнения
fun work350() {
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()
    val e = scanner.nextInt()
    var x = 0.0
    var i = 0

    while (x < 1000) {
        val numerator: Double = a * x.pow(3.0) + b * x.pow(2.0 + c * x + d)
        val denominator: Double = x - e
        x++

        if (denominator == 0.0) continue

        if (numerator / denominator == 0.0 && numerator % denominator == 0.0) {
            i++
        }
    }

    println(i)
}

// Умножить числа без использования *
fun work112202() {
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    var c = 0
    var n = 0

    val term = if (b > 0) a else -a

    while (n < b.absoluteValue) {
        c += term
        n++
    }

    println(c)
}

// Остаток от деления x на А = B и от деления на С = D
fun work112208() {
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()
    var x = 10000

    while (x < 100000) {
        if (x % a == b && x % c == d) {
            println(x)
        }

        x++
    }
}

// Сумма цифр числа
fun work112213() {
    var a = scanner.nextInt()
    var b = 0

    while (a > 0) {
        b += (a % 10)
        a /= 10
    }

    println(b)
}


// Есть ли две одинаковые цифры рядом
fun work112214Old() {
    var a = scanner.nextInt()
    var lastDigit = 0

    while (a != 0) {
        lastDigit = (a % 10)
        a /= 10
        if (lastDigit == (a % 10)) break
    }

    if (lastDigit == (a % 10)) {
        println("Да")
    } else {
        println("Нет")
    }
}

fun work112214() {
    val a = scanner.nextInt()

    if (isTwoSimilarNumbers(a)) {
        println("Да")
    } else {
        println("Нет")
    }
}

private fun isTwoSimilarNumbers(a: Int): Boolean {
    var lastDigit = 0
    var fullNumber = a

    while (fullNumber != 0) {
        lastDigit = (fullNumber % 10)
        fullNumber /= 10
        if (lastDigit == (fullNumber % 10)) break
    }

    return lastDigit == (fullNumber % 10)
}
