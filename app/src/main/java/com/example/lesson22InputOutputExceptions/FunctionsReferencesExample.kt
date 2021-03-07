package com.example.lesson22InputOutputExceptions

private fun main() {
    val value = buildDifficultMessage()
        .also { println(it) }

    val value1 = buildDifficultMessage()
        .also(::println)

    // Use value in future here
}

private fun buildDifficultMessage() = "message"