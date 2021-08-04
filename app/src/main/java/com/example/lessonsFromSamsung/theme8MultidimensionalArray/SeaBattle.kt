package com.example.lessonsFromSamsung.theme8MultidimensionalArray

import com.example.lessonsFromSamsung.utils.createTwoArrayWithZero
import com.example.lessonsFromSamsung.utils.printIntTwoArray
import java.util.*

private val random = Random()

private fun main() {
    val array = createTwoArrayWithZero(10)

    for (shipSize in 1..4) {
        putShips(array, shipSize)
    }

    printIntTwoArray(array)
}

private fun putShips(array: Array<Array<Int>>, shipSize: Int) {
    for (shipDeckCount in 4 downTo shipSize) {
        var shipIsPut = false

        while (!shipIsPut) {
            shipIsPut = putShipIfCan(array, shipSize)
        }
    }
}

private fun putShipIfCan(array: Array<Array<Int>>, shipSize: Int): Boolean {
    var shipIsPut = false
    val i = random.nextInt(array.size - 1)
    val j = random.nextInt(array.first().size - 1)
    val freeCell = isFreePosition(array, i, j)
    val deckDeltas = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    if (freeCell) {
        for (delta in deckDeltas) {
            shipIsPut = putShipIfCan(
                array = array,
                i = i,
                j = j,
                deltas = delta,
                shipSize = shipSize
            )

            if (shipIsPut) break
        }
    }

    return shipIsPut
}

private fun isFreePosition(array: Array<Array<Int>>, i: Int, j: Int): Boolean {
    val rightBarrier = array.size - 1
    val bottomBarrier = array.first().size - 1

    val leftTopCondition = i == 0 || j == 0 || array[i - 1][j - 1] == 0
    val middleTopCondition = i == 0 || array[i - 1][j] == 0
    val rightTopCondition = i == 0 || j == rightBarrier || array[i - 1][j + 1] == 0

    val leftMiddleCondition = j == 0 || array[i][j - 1] == 0
    val rightMiddleCondition = j == rightBarrier || array[i][j + 1] == 0
    val centralCondition = array[i][j] == 0

    val leftBottomCondition = i == bottomBarrier || j == 0 || array[i + 1][j - 1] == 0
    val middleBottomCondition = i == bottomBarrier || array[i + 1][j] == 0
    val rightBottomCondition = i == bottomBarrier || j == rightBarrier || array[i + 1][j + 1] == 0

    val topCondition = leftTopCondition && middleTopCondition && rightTopCondition
    val middleCondition = leftMiddleCondition && centralCondition && rightMiddleCondition
    val bottomCondition = leftBottomCondition && middleBottomCondition && rightBottomCondition

    return topCondition && middleCondition && bottomCondition
}

private fun putShipIfCan(
    array: Array<Array<Int>>,
    i: Int,
    j: Int,
    deltas: Pair<Int, Int>,
    shipSize: Int
): Boolean {
    var canPutShip = true
    val iDeckDelta = deltas.first
    val jDeckDelta = deltas.second
    for (deck in 1 until shipSize) {
        if (i + deck * iDeckDelta < 0 ||
            j + deck * jDeckDelta < 0 ||
            i + deck * iDeckDelta > array.size - 1 ||
            j + deck * jDeckDelta > array.size - 1 ||
            !isFreePosition(array, i + deck * iDeckDelta, j + deck * jDeckDelta)
        ) {
            canPutShip = false
            break
        }
    }

    if (canPutShip) {
        for (deck in 0 until shipSize) {
            array[i + deck * iDeckDelta][j + deck * jDeckDelta] = shipSize
        }
    }

    return (canPutShip)
}