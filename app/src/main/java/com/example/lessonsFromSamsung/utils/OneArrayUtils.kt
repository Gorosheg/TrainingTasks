package com.example.lessonsFromSamsung.utils

import java.util.*

fun createIntArray(inScanner: Scanner): Array<Int> {
    val arraySize = inScanner.nextInt()
    return Array(arraySize) { inScanner.nextInt() }
}

fun createArrayWithZero(size: Int): Array<Int> {
    return Array(size) { 0 }
}

fun createSequentialIntArray(size: Int = 30): Array<Int> {
    return Array(size) { i -> i + 10 }
}

fun createRandomIntArray(size: Int = 30, maxValue: Int = 100): Array<Int> {
    val random = Random()
    return Array(size) { random.nextInt(maxValue) }
}

fun Array<Int>.print() {
    for (i in 0 until size - 1) {
        val element = this[i]
        print("$element, ")
    }

    if (isNotEmpty()) {
        print(last())
    }
}