package com.example.lessonsFromSamsung.theme4_LogicalExpressions

internal class PowOfTwoData(
    private val testDesc: String,
    val number: Int,
    val result: Boolean
) {
    override fun toString(): String {
        return "$testDesc: number to check = $number EXPECT \"$result\""
    }
}