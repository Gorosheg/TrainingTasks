package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

/**
 * enum - ограниченное перечисление.
 * При вызове Enum не вызыается конструктор.
 * Enum - константа. При его вызове нельзя передавать свои параметры.
 */
enum class ExampleEnum {
    CLEAR,
    SNOW;
}

private var field1 = 1
private var field2 = 2

private val Int.exampleField: Unit
    get() = when (this) {
        1 -> field1 = 2
        2 -> field2 = 1
        else -> field1 = 3
    }

// Если перебирать enum в when, то не нужна ветка else.
private val ExampleEnum.exampleField: String
    get() = when (this) {
        ExampleEnum.CLEAR -> TODO()
        ExampleEnum.SNOW -> TODO()
    }