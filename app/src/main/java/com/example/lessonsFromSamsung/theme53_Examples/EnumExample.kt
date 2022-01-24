package com.example.lessonsFromSamsung.theme53_Examples

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


