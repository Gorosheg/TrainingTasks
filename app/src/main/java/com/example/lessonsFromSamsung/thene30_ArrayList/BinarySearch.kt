package com.example.lessonsFromSamsung.thene30_ArrayList

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.print
import com.example.lessonsFromSamsung.utils.scanner
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

private fun main() {
    createRandomIntArray(size = 21, maxValue = 50).run {
        sort()
        print()

        binarySearch().let(::println)
    }
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

private fun Array<Int>.binarySearch(): Int {
    var index = size / 2
    var supposedNumber = this[index]
    val searchingNumber: Int = scanner.nextInt()

    while (supposedNumber != searchingNumber) {
        if (searchingNumber < supposedNumber) {
            index /= 2
        } else if (searchingNumber > supposedNumber) {
            index += index / 2
        }
        supposedNumber = this[index]
    }
    return index
}
