package com.example.lessonsFromSamsung.theme5_CyclesWhileAndDoWhile

import com.example.lessonsFromSamsung.utils.scanner

//На каком мосту будет авария work5ex3
private fun main() {
    val numberOfBridges = scanner.nextInt()
    var i = 0
    val bridgesHeights = mutableListOf<Int>()

    while (i < numberOfBridges) {
        bridgesHeights += scanner.nextInt()
        i++
    }

    val crash = busAndBridgeCalculator(bridgesHeights)

    if (crash == 0) {
        println("Аварий нет")
    } else {
        println("Авария на $crash мосту")
    }
}

fun busAndBridgeCalculator(bridgesHeights: List<Int>): Int {
    var crash = 0
    var i = 0

    while (i < bridgesHeights.size) {
        val bridgeHeight = bridgesHeights[i]

        if (crash == 0 && bridgeHeight <= 437) {
            crash = i + 1
        }

        i++
    }

    return crash
}