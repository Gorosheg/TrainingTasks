package com.example.lessonsFromSamsung.theme6CyclesAndArrays

import com.example.lessonsFromSamsung.utils.*
import kotlin.math.absoluteValue

private fun main() {
    val array = createSequentialIntArray(size = 4)
    printIntArray(array)
}

private fun commonFor() {
    val n = scanner.nextInt()

    for (i in 1..n) {
        //println(i)
    }

    for (i in 1 until n) {
        //println(i)
    }

    for (i in n downTo 1) {
        //println(i)
    }

    for (i in 0 until n step 3) {
        //println(i)
    }


    for (i in 1 until n) {
        if (i % 2 == 0) continue
        if (i > 10) break
        println(i)
    }

    loop@ // Используется для выхода из вложеных циклов
    for (i in 1 until n) {
        if (i > 10) break@loop
        println(i)
    }
}

// [ 0, 1, 2, 3, 4, 5] - индексы
// [ 5, 4, 2, 7, 9, 0] - элементы массива
private fun commonArray() {
    val intArrayWithZero = Array(6) { 0 }

    for (i in 0 until intArrayWithZero.size) {
        val element = intArrayWithZero[i]
        //print(element.toString() + ", ")
        print("$element, ")
    }

    println("")

    val intArrayFilledSequential = Array(6) { it }

    for (element in intArrayFilledSequential) {
        print("$element, ")
    }

    println("")

    val intArrayEven = Array(6) { index ->
        index * 2
    }

    intArrayEven.forEach { element ->
        print("$element, ")
    }
}

private fun sumNumbers() {
    val n = scanner.nextInt()
    var sum = 0

    for (i in 0 until n) {
        sum += scanner.nextInt()
    }

    println(sum)
}

private fun printSquareOfStars(squareSize: Int = scanner.nextInt()) {
    for (i in 0 until squareSize) {
        for (j in 0 until squareSize) {
            print("* ")
        }

        println("")
    }
}

private fun printRandomArray() {
    val arrayWithRandom = createRandomIntArray()
    printIntArray(arrayWithRandom)
}

// Сумма рандомных чисел
private fun ex3() {
    val arrayWithRandom = createRandomIntArray()
    val sum = sumRandomNumbers(arrayWithRandom)
    printIntArray(arrayWithRandom)
    println(sum)
}

private fun sumRandomNumbers(arrayWithRandom: Array<Int>): Int {
    var sum = 0

    for (i in arrayWithRandom.indices) {
        sum += arrayWithRandom[i]
    }

    return sum
}

// Меньшее из рандомных чисел
private fun ex4() {
    val arrayWithRandom = createRandomIntArray()
    var minimum = Int.MAX_VALUE

    for (i in arrayWithRandom.indices) {
        if (arrayWithRandom[i] < minimum) {
            minimum = arrayWithRandom[i]
        }
    }

    printIntArray(arrayWithRandom)
    println(minimum)
}

// Меньшее из рандомных чисел
private fun ex4_declarative() {
    val arrayWithRandom = createRandomIntArray()
    val minimum = arrayWithRandom.min() ?: 0
    printIntArray(arrayWithRandom)
    println(minimum)
}

private fun createAndPrintCountOfPositiveNumbers() {
    val intArray = createIntArray(scanner)
    val result = countOfPositiveNumbers(intArray)
    println(result)
}

private fun countOfPositiveNumbers(array: Array<Int>): Int {
    var result = 0

    for (i in array.indices) {
        if (array[i] > 0) {
            result++
        }
    }

    return result
}

// массив наоборот
private fun work69() {
    val intArray = createIntArray(scanner)
    reverseArray(intArray)
    printIntArray(intArray)
}

// Найти место новому числу в ряду чисел по убыванию
private fun findPositionOfNumber() {
    val intArray = createIntArray(scanner)
    var answer = 0
    val newNumber = scanner.nextInt()

    for (i in intArray.indices) {
        answer = i + 2

        if (newNumber <= intArray[i] &&
            (i == intArray.size - 1 || newNumber > intArray[i + 1])
        ) {
            break
        }
    }

    println(answer)
}

private fun moveNumbersInArrayInCircle() {
    val intArray = createIntArray(scanner)
    moveNumbersInArrayInCircle(intArray)
    printIntArray(intArray)
}

private fun moveNumbersInArrayInCircle(intArray: Array<Int>) {
    val moveNumber = scanner.nextInt()

    for (i in 0 until moveNumber.absoluteValue) {
        if (moveNumber < 0) {
            moveArrayToLeft(intArray)
        } else {
            moveArrayToRight(intArray)
        }
    }
}

private fun moveArrayToLeft(intArray: Array<Int>) {
    val temp: Int = intArray[0]

    for (j in 0 until intArray.size - 1) {
        intArray[j] = intArray[j + 1]
    }

    intArray[intArray.size - 1] = temp
}


private fun moveArrayToRight(intArray: Array<Int>) {
    val temp = intArray[intArray.size - 1]

    for (j in (intArray.size - 2) downTo 0) {
        intArray[j + 1] = intArray[j]
    }

    intArray[0] = temp
}


private fun reverseArray(intArray: Array<Int>) {
    var temporary: Int
    val arraySize = intArray.size

    for (i in 0 until arraySize / 2) {
        val rightIndex = arraySize - 1 - i
        temporary = intArray[rightIndex]
        intArray[rightIndex] = intArray[i]
        intArray[i] = temporary
    }
}