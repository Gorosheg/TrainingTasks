package com.example.lessonsFromSamsung.utils

import java.util.*

fun createIntArray(inScanner: Scanner): Array<Int> {
    val arraySize = inScanner.nextInt()
    return Array(arraySize) { inScanner.nextInt() }
}

fun createArrayWithZero(size1: Int): Array<Int> {
    return Array(size1) { 0 }
}

fun createSequentialIntArray(size: Int = 30): Array<Int> {
    return Array(size) { i -> i + 10 }
}

fun createRandomIntArray(size: Int = 30, maxValue: Int = 100): Array<Int> {
    val random = Random()
    return Array(size) { random.nextInt(maxValue) }
}

fun printIntArray(array: Array<Int>) {
    for (i in 0 until array.size - 1) {
        val element = array[i]
        print("$element, ")
    }

    if (array.isNotEmpty()) {
        print(array.last())
    }
}