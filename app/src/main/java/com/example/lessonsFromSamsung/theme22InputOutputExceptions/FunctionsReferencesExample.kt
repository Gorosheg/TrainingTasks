package com.example.lessonsFromSamsung.theme22InputOutputExceptions

private fun main() {
    val value = buildDifficultMessage()
        .also { println(it) }

    // Function reference - ссылка на функцию
    val value1 = buildDifficultMessage()
        .also(::println)

    // Use value in future here
}

private fun buildDifficultMessage() = "message"