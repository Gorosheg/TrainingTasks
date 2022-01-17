package com.example.lessonsFromSamsung.theme4_LogicalExpressions

// Является ли число степенью двойки
fun ifDegreeOfTwo(number: Int): Boolean {
    val counting = number - 1 and number
    return counting == 0
}