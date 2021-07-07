package com.example.lessonsFromSamsung.theme27_2Dgraphics

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.printIntArray
import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    val array = createRandomIntArray(10, 50)

    printIntArray(array)
    array.sort()
    println("")
    printIntArray(array)
    println("")
    searchNumber(array)
}

private fun Array<Int>.sort() {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1 until size) {
            val previous = this[i - 1]
            val current = this[i]
            if (previous > current) {
                swap(this, i - 1, i)
                sorted = false
            }
        }
    }
}

private fun swap(array: Array<Int>, previous: Int, current: Int) {
    val container = array[previous]
    array[previous] = array[current]
    array[current] = container
}

private fun searchNumber(array: Array<Int>, ) {
    val n = scanner.nextInt()
    for (i in array.indices) {
        if (array[i] == n) {
            println(i + 1)
        }
    }
}