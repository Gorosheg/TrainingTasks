package com.example.lessonsFromSamsung.theme53_Examples

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
        ExampleEnum.CLEAR -> "Clear"
        ExampleEnum.SNOW -> "Snow"
    }




private enum class Color(val rgb: Int) { // Перечисление
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

private fun main() {
    val colors: Array<Color> = Color.values() // Array(RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)))
    val colors2: Array<Color> = enumValues<Color>() // Array(RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)))

    val names: String = colors.joinToString { color -> color.name } // "RED, GREEN, BLUE"

    val blue: Color = Color.valueOf("BLUE") // BLUE(0x0000FF)
    val blue2: Color = enumValueOf("BLUE") // BLUE(0x0000FF)

    val enumName = blue.name // BLUE
    val enumIndex = blue.ordinal // 2
}


