package com.example.lessonsFromSamsung.theme5_CyclesWhileAndDoWhile

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BusAndBridgesTest {

    @Test
    fun `height is ok EXPECTED no crashes`() {
        // Given
        val bridgesHeights = listOf(763)
        val expectedResult = 0

        // When
        val actualResult = busAndBridgeCalculator(bridgesHeights)

        // Then
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `second height is not ok EXPECTED crash on second bridge`() {
        val bridgesHeights = listOf(763, 245, 113)
        val expectedResult = 2

        val actualResult = busAndBridgeCalculator(bridgesHeights)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `first height is equals to bridge EXPECTED crash on first bridge`() {
        val bridgesHeights = listOf(437)
        val expectedResult = 1

        val actualResult = busAndBridgeCalculator(bridgesHeights)

        assertEquals(expectedResult, actualResult)
    }

}