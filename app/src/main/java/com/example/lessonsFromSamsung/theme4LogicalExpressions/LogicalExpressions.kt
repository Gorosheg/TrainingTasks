package com.example.lessonsFromSamsung.theme4LogicalExpressions

import com.example.lessonsFromSamsung.utils.scanner
import java.util.*
import kotlin.math.cos
import kotlin.math.pow

private fun main() {
    scanner.useLocale(Locale.US)
    work112166()
}

// Поиск цифры 3 в двухзначном числе
fun work4() {
    val inValue = scanner.nextInt()

    if (inValue / 10 == 3 || inValue % 10 == 3) {
        println("Да")
    } else {
        println("Нет")
    }
}

// Поиск цифры 3 в двухзначном числе
fun work4a() {
    val inValue = scanner.nextInt()
    val outValue = if (inValue / 10 == 3 || inValue % 10 == 3) "Да" else "Нет"
    println(outValue)
}

// Вывести месяц по его номеру
fun work5() {
    val outValue = when (scanner.nextInt()) {
        1 -> "Январь"
        2 -> "Февраль"
        3 -> "Март"
        4 -> "Апрель"
        5 -> "Май"
        6 -> "Июнь"
        7 -> "Июль"
        8 -> "Август"
        9 -> "Сентябрь"
        10 -> "Октябрь"
        11 -> "Ноябрь"
        12 -> "Декабрь"
        else -> "Такого месяца нет"
    }

    println(outValue)
}

fun work5a() {
    val outValue = when (scanner.nextLine()) {
        "Январь" -> 1
        "Февраль" -> 2
        "Март" -> 3
        "Апрель" -> 4
        "Май" -> 5
        "Июнь" -> 6
        "Июль" -> 7
        "Август" -> 8
        "Сентябрь" -> 9
        "Октябрь" -> 10
        "Ноябрь" -> 11
        "Декабрь" -> 12
        else -> 0
    }

    println(outValue)
}


// соответствует ли число функции
fun work112166() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()

    val outValue =
        if (y in 0.0..0.5 && y <= cos(x)) "Да"
        else "Нет"

    println(outValue)
}

// соответствует ли число функции
fun work112168() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val isInParabola = y >= xInSquare - 2

    if (isInParabola && y <= x || y <= -x && isInParabola) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112170() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val yInSquare = y.pow(2.0)
    val isInCircle = xInSquare + yInSquare <= 1

    if (isInCircle && y <= x || isInCircle && y >= -x) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112171() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val parabola = 2 * xInSquare

    if (y >= parabola && y >= 1 - x && x < 1 || y <= parabola && y >= 1 - x && x in 0.0..1.0) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112172() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val yInSquare = y.pow(2.0)
    val isInCircle = xInSquare + yInSquare <= 1

    if (isInCircle && x >= 1 || y >= x - 1 && x > 0 && y < 1) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112173() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val yInSquare = y.pow(2.0)
    val isInCircle = xInSquare + yInSquare <= 1

    if (isInCircle || y in 0.0..1.0 && x in 0.0..1.0) {
        println("Да")
    } else {
        println("Нет")
    }
}

// определить, сколько вагонов в поезде
fun work38() {
    val fromHead = scanner.nextInt()
    val vanNumber = scanner.nextInt()

    if (vanNumber != fromHead) {
        println(vanNumber + fromHead - 1)
    } else {
        println(0)
    }
}

// соответствует ли число функции
fun work112165() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val yInSquare = y.pow(2.0)
    val isInCircle = xInSquare + yInSquare >= 4

    if (isInCircle && x <= 2 && y >= 0 && y <= x) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112167() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val parabola = 2 - xInSquare >= y

    if (parabola && y >= x || parabola && y <= x && y >= 0) {
        println("Да")
    } else {
        println("Нет")
    }
}

// соответствует ли число функции
fun work112169() {
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()
    val xInSquare = x.pow(2.0)
    val yInSquare = y.pow(2.0)
    val isInCircle = xInSquare + yInSquare <= 1

    if (isInCircle && y >= x || isInCircle && x <= 0) {
        println("Да")
    } else {
        println("Нет")
    }
}

// Является ли число степенью двойки
fun work3060() {
    val x = scanner.nextInt()
    val counting = x - 1 and x

    if (counting == 0) {
        println("Да")
    } else {
        println("Нет")
    }
}