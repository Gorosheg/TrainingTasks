package com.example.lessonsFromSamsung.thene30_ArrayList

import com.example.lessonsFromSamsung.utils.createRandomIntArray
import com.example.lessonsFromSamsung.utils.print
import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    createRandomIntArray(size = 21, maxValue = 50).run {
        sort()
        print()

        val result = binarySearch(scanner.nextInt())
        println(result + 1)
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
                swap(previous = i - 1, current = i)
                sorted = false
            }
        }
    }
}

private fun Array<Int>.swap(previous: Int, current: Int) {
    val temp = this[previous]
    this[previous] = this[current]
    this[current] = temp
}

private fun Array<Int>.binarySearch(searchingNumber: Int): Int {
    var index = size / 2
    var supposedNumber = this[index]

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
