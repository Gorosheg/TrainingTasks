package com.example.lessonsFromSamsung.theme27_2Dgraphics

import com.example.lessonsFromSamsung.utils.createRandomIntTwoArray
import com.example.lessonsFromSamsung.utils.printIntTwoArray

private fun main() {
    val array = createRandomIntTwoArray(size = 4, maxValue = 50)

    printIntTwoArray(array)
    sortTwoIntArray(array)
    println()
    printIntTwoArray(array)
}

private fun sortTwoIntArray(array: Array<Array<Int>>) {
    var sortVertical = false
    var sortedHorizontal = false
    var sortedRightColumn = false
    var sortedBottomLine = false
    var sortedExtremeInRow = false

    while (!sortVertical || !sortedHorizontal || !sortedRightColumn || !sortedBottomLine || !sortedExtremeInRow) {

        sortVertical = true
        sortedHorizontal = true
        sortedRightColumn = true
        sortedBottomLine = true
        sortedExtremeInRow = true

        for (i in 0 until array.size - 1) {
            for (j in 0 until array[i].size - 1) {

                sortVertical = verticalSort(array, i, j)

                sortedHorizontal = sortHorizontal(array, i, j)

                sortedRightColumn = sortRightColumn(array, i)

                sortedBottomLine = sortDownLine(array, j)

                sortedExtremeInRow = sortExtremeInRow(array, i, sortedExtremeInRow)
            }
        }
    }
}

private fun sortExtremeInRow(
    array: Array<Array<Int>>,
    i: Int,
    sortedExtremeInRow: Boolean
): Boolean {
    var sortedExtremeInRow1 = sortedExtremeInRow
    if (array[i][array.size - 1] > array[i + 1][0]) {
        swapExtremeInRow(array, i)
        sortedExtremeInRow1 = false
    }
    return sortedExtremeInRow1
}

private fun sortDownLine(
    array: Array<Array<Int>>,
    j: Int
): Boolean {
    if (array[array.size - 1][j + 1] < array[array.size - 1][j]) {
        swapDownLine(array, j)
        return false
    }
    return true
}

private fun sortRightColumn(
    array: Array<Array<Int>>,
    i: Int
): Boolean {
    if (array[i + 1][array.size - 1] < array[i][array.size - 1]) {
        swapRightColumn(array, i)
        return false
    }
    return true
}

private fun sortHorizontal(
    array: Array<Array<Int>>,
    i: Int,
    j: Int
): Boolean {
    if (array[i][j + 1] < array[i][j]) {
        swapHorizontal(array, i, j)
        return false
    }
    return true
}

private fun verticalSort(
    array: Array<Array<Int>>,
    i: Int,
    j: Int
): Boolean {
    if (array[i + 1][j] < array[i][j]) {
        swapVertical(array, i, j)
        return false
    }
    return true
}

private fun swapVertical(array: Array<Array<Int>>, i: Int, j: Int) {
    val container = array[i + 1][j]
    array[i + 1][j] = array[i][j]
    array[i][j] = container
}

private fun swapHorizontal(array: Array<Array<Int>>, i: Int, j: Int) {
    val container = array[i][j + 1]
    array[i][j + 1] = array[i][j]
    array[i][j] = container
}

private fun swapRightColumn(array: Array<Array<Int>>, i: Int) {
    val container = array[i + 1][array.size - 1]
    array[i + 1][array.size - 1] = array[i][array.size - 1]
    array[i][array.size - 1] = container
}


private fun swapDownLine(array: Array<Array<Int>>, j: Int) {
    val container = array[array.size - 1][j + 1]
    array[array.size - 1][j + 1] = array[array.size - 1][j]
    array[array.size - 1][j] = container
}

private fun swapExtremeInRow(array: Array<Array<Int>>, i: Int) {
    val container = array[i][array.size - 1]
    array[i][array.size - 1] = array[i + 1][0]
    array[i + 1][0] = container
}
