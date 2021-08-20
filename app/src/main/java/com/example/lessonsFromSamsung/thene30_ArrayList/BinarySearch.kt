package com.example.lessonsFromSamsung.thene30_ArrayList

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.printIntArray
import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    val array = createIntArray()
    array.sort()
    printIntArray(array)
    val index = binarySearch(array)
    println(index)
}

private fun createIntArray(): Array<Int> {
    return createRandomIntArray(21, 50)
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

private fun binarySearch(array: Array<Int>): Int {
    var index = array.size / 2
    var supposedNumber = array[index]
    val searchingNumber: Int = scanner.nextInt()

    while (supposedNumber != searchingNumber) {
        if (searchingNumber < supposedNumber) {
            index /= 2
        } else if (searchingNumber > supposedNumber) {
            index += index / 2
        }
        supposedNumber = array[index]
    }
    return index
}
