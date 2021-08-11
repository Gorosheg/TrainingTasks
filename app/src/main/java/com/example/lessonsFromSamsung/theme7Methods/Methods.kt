package com.example.lessonsFromSamsung.theme7Methods

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.scanner
import kotlin.math.max

private fun main() {
    zeroArguments()
    oneArgument(1)

    twoArgument(1, "qwe")
    twoArgument(argumentOne = 1, argumentTwo = "qwe")

    manyArguments(1, 2, 3)
    arrayArgument(intArrayOf(1, 2, 3))
}

private fun zeroArguments() {}

private fun oneArgument(argument: Int) {}

private fun twoArgument(argumentOne: Int, argumentTwo: String) {}

private fun manyArguments(vararg many: Int) {
    val array: IntArray = many
}

private fun arrayArgument(array: IntArray) {}

// ==============================================================

private fun printMaxValueForRandomArrays() {
    printMaxValueForRandomArrays("Anna", "Petya", "Kolya")
}

private fun printMaxValueForRandomArrays(vararg names: String) {
    for (name in names) {
        printMaxValueForRandomArray(name)
    }
}

private fun printMaxValueForRandomArray(name: String) {
    val arrayWithRandom = createRandomIntArray()
    val maxArg = findMaxArrayNumber(arrayWithRandom)
    println("Max array value of $name is $maxArg")
}

private fun findMaxArrayNumber(array: Array<Int>): Int {
    var maximum = 0

    for (i in array.indices) {
        if (array[i] > maximum) {
            maximum = array[i]
        }
    }

    return maximum
}

private fun fibanachiTask() {
    println(fibanachiSimple(8))
    println(fibanachi(8))
}

private fun fibanachiSimple(number: Int): Int {
    var firstValue = 0
    var secondValue = 1

    for (i in 2..number) {
        if (i % 2 == 0) firstValue += secondValue
        else secondValue += firstValue
    }

    return max(firstValue, secondValue)
}

private fun fibanachi(number: Int): Int {
    if (number == 0) return 0
    if (number == 1) return 1

    return fibanachi(number - 1) + fibanachi(
        number - 2
    )
}

private fun numberFounderTask() {
    println(numberFounder(8))
    println(numberFounderRecursive(8))
}

private fun numberFounder(number: Int): Int {
    val firstValue = 0
    var result = firstValue

    for (i in 1 until number) {
        result++
    }

    return result
}

private fun numberFounderRecursive(number: Int): Int {
    if (number == 1) return 0
    return numberFounderRecursive(number - 1) + 1
}

// ==============================================================

private fun findMinNumber() {
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()
    findMinNumber(a, b, c, d)
}

private fun findMinNumber(a: Int, b: Int, c: Int, d: Int) {
    val firstOption = findMinValue(a, b)
    val secondOption = findMinValue(c, d)
    val minimum = findMinValue(firstOption, secondOption)

    println(minimum)
}

private fun findMinValue(a: Int, b: Int): Int {
    return if (a < b) a else b
}

private fun findDegreeOfNumber(a: Double, n: Int) {
    var answer = 1.0

    for (i in 1..n) {
        answer *= a
    }

    println(answer.toInt())
}

private fun findPrimeNumbers() {
    val number = scanner.nextInt()

    if (isPrime(number)) {
        println("Сложное")

    } else {
        println("Простое")
    }
}

private fun isPrime(number: Int): Boolean {
    var chek = 0

    for (i in 2 until number) {
        chek = number % i
        if (chek == 0) break
    }
    return chek == 0
}


private fun findNOD() {
    val firstNumber = scanner.nextInt()
    val secondNumber = scanner.nextInt()
    var a: Int
    var b = 0

    loop@
    for (i in firstNumber downTo 1) {
        if (firstNumber % i == 0) {
            a = i

            for (j in secondNumber downTo 1) {
                if (secondNumber % j == 0) {
                    b = j
                    if (a == b) break@loop
                }
            }
        }
    }

    println(b)
}