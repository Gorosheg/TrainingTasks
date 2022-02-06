package com.example.lessonsFromSamsung.theme53_Examples

private fun main() {
    throwMyError()
    val q = "qwer"
}

private fun throwMyError(): Nothing {
    throw myError()
}

private fun myError(): Exception {
    return Exception("Error!!! Падаем")
}