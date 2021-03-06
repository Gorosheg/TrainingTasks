package com.example.lessonsFromSamsung.theme22_InputOutputExceptions

private class Example {

    var some: Int = 0

}

private object KotlinStandardExample {

    var some = 0

    private fun main() {
        // Обычная запись, без всех этих функций
        val example0 = Example()
        example0.some = 0

        // Меняет контекст. Возвращает первоначальное значение
        val exampleApply: Example = Example().apply {
            val localThis: Example = this
            some = 1 // Скоуп экземпла
        }

        // Не меняет контекст. Возвращаетп первоначальное значение
        val exampleAlso: Example = Example().also { example ->
            val localThis: KotlinStandardExample = this
            some = 1 // Скоуп нашего класса KotlinStandardExample
            example.some = 2
        }

        // Меняет контекст. Возвращает последнее значение
        val exampleRun: Int = Example().run {
            some = 3

            if (true) 0
            else some
        }

        // Не меняет контекст. Возвращает последнее значение
        val exampleLet: Unit = Example().let { example ->
            example.some = 4
        }


        // Run equivalent
        val exampleWith: Int = with(Example()) {
            some = 5
            some
        }
    }
}

private data class Music(val title: String, val author: String)

private fun componentExample() {
    val music = Music("Kalinka", "Abba")

    val title1 = music.component1()
    val author1 = music.component2()

    val (title, author) = music // То же самое, что и выше

    println("$title $author")

    musicBuilder { (title, author) ->
        println("$title $author")
    }
}

private fun musicBuilder(callback: (Music) -> Unit) {
    callback.invoke(Music("Kalinka", "Abba"))
}