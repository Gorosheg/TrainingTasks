package com.example.lessonsFromSamsung.theme4_LogicalExpressions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ParametrizedPowOfTwoTest {

    @ParameterizedTest(name = "[{index}]: {0}")
    @MethodSource("getDegreeOfTwoData")
    fun ifPowOfTwo(data: PowOfTwoData) {
        assertEquals(data.result, ifDegreeOfTwo(data.number))
    }

    companion object {

        @Suppress("unused")
        @JvmStatic
        private fun getDegreeOfTwoData(): List<PowOfTwoData> = listOf(
            PowOfTwoData(testDesc = "The number is a power of two", number = 16, result = true),
            PowOfTwoData(testDesc = "The number isn't a power of two", number = 23, result = false)
        )
    }

}