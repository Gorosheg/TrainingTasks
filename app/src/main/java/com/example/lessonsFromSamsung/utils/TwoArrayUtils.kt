package com.example.lessonsFromSamsung.utils

import java.util.*

fun createIntTwoArray(inScanner: Scanner): Array<Array<Int>> {
    val arraySize = inScanner.nextInt()

    return Array(arraySize) { i ->
        Array(arraySize) { j ->
            inScanner.nextInt()
        }
    }
}

fun createTwoArrayWithZero(size1: Int, size2: Int = size1): Array<Array<Int>> {
    return Array(size1) {
        Array(size2) {
            0
        }
    }
}

fun createSequentialIntTwoArray(size: Int = 30): Array<Array<Int>> {
    return Array(size) { i ->
        Array(size) { j ->
            i * size + j
        }
    }
}

fun createRandomIntTwoArray(size: Int = 30, maxValue: Int = 100): Array<Array<Int>> {
    val random = Random()

    return Array(size) { i ->
        Array(size) { j ->
            random.nextInt(maxValue)
        }
    }
}

fun printIntTwoArray(array: Array<Array<Int>>) {
    for (i in array.indices) {
        for (j in array[i].indices) {
            val element = array[i][j]
            print("$element ")
        }

        println()
    }
}