package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

enum class ExampleEnum {

    CLEAR,
    SNOW;

}

private const val CONST1 = 1
private const val CONST2 = 2

private val Int.exampleField: String
    get() = when (this) {
        1 -> TODO()
        2 -> TODO()
        else -> TODO()
    }

private val ExampleEnum.exampleField: String
    get() = when (this) {
        ExampleEnum.CLEAR -> TODO()
        ExampleEnum.SNOW -> TODO()
    }