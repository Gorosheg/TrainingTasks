package com.example.lessonsFromSamsung.theme22InputOutputExceptions

private fun main() {
    val example0 = Example()
    example0.some = 0

    // Меняет контекст. Возвращает первоначальное значение
    val exampleApply: Example = Example().apply {
        some = 1
    }

    // Не меняет контекст. Возвращаетп первоначальное значение
    val exampleAlso: Example = Example().also { example ->
        example.some = 2
    }

    // Меняет контекст. Возвращает последнее значение
    val exampleRun = Example().run {
        some = 3

        if (true) 0
        else some
    }

    // Не меняет контекст. Возвращает последнее значение
    val exampleLet = Example().let { example ->
        example.some = 4
    }

    // Run equailent
    val exampleWith = with(Example()) {
        some = 5
        some
    }
}

private class Example {

    var some: Int = 0

}