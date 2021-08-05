package com.example.lessonsFromSamsung.theme27_2Dgraphics

import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    val text = scanner.nextLine().toCharArray()
    text.forEach {
        val code = it.code + 3
        print(code.toChar())
    }
}