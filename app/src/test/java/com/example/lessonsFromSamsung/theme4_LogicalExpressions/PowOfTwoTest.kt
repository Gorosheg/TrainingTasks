package com.example.lessonsFromSamsung.theme4_LogicalExpressions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PowOfTwoTest {

    @Test
    fun `number is degree of two EXPECTED true`() {
        val number = 16
        val expectedResult = true

        val actualResult = ifDegreeOfTwo(number)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `number isn't degree of two EXPECTED false`() {
        val number = 23
        val expectedResult = false

        val actualResult = ifDegreeOfTwo(number)

        assertEquals(expectedResult, actualResult)
    }

}