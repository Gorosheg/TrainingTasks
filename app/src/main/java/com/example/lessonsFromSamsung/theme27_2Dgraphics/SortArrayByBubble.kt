package com.example.lessonsFromSamsung.theme27_2Dgraphics

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.printIntArray

val array = createRandomIntArray(10, 50)

private fun main() {
    printIntArray(array)
    sort()
    println("")
    printIntArray(array)
}

private fun sort() {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1 until array.size) {
            val previous = array[i - 1]
            val current = array[i]
            if (previous > current) {
                swap(i - 1, i)
                sorted = false
            }
        }
    }
}

private fun swap(previous: Int, current: Int) {
    val container = array[previous]
    array[previous] = array[current]
    array[current] = container
}