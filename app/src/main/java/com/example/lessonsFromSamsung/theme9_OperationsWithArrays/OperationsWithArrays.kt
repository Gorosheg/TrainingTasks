package com.example.lessonsFromSamsung.theme9_OperationsWithArrays

import com.example.lessonsFromSamsung.utils.createIntArray
import com.example.lessonsFromSamsung.utils.print
import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    compressingArrayOfIntegers1()
}

private fun compressingArrayOfIntegers1() {
    val array = createIntArray(scanner)

    for (i in array.indices) {
        moveElementsAndChekLastElementsForZero(array, i)
    }

    array.print()
}


private fun moveElementsAndChekLastElementsForZero(array: Array<Int>, i: Int) {
    loop@
    while (array[i] == 0) {
        moveElementsLeft(i, array)

        for (k in i until array.size) {
            if (array[k] != 0) break
            if (k == array.lastIndex) break@loop
        }
    }
}


private fun moveElementsLeft(i: Int, array: Array<Int>) {
    for (j in i..array.size - 2) {
        array[j] = array[j + 1]
    }

    array[array.size - 1] = 0
}