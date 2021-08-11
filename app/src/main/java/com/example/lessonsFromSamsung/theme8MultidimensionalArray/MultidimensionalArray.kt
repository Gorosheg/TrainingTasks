package com.example.lessonsFromSamsung.theme8MultidimensionalArray

import com.example.lessonsFromSamsung.utils.*

private fun main() {
    snakeTwoArray()
}

private fun twoArrayExample() {
    val array = Array(5) {
        Array(5) {
            -1
        }
    }

    println(array[2][2])
    array[2][2] = 13
    println(array[2][2])
}

private fun twoArrayRandomSizeExample() {
    val array = Array(3) { i ->
        Array(i + 2) {
            -1
        }
    }
}

private fun work1() {
    val array = createSequentialIntTwoArray(3)
    printIntTwoArray(array)
    changingElementsOfArray(array)
    printIntTwoArray(array)
}


private fun work2() {
    val array = createRandomIntTwoArray(3)
    printIntTwoArray(array)
    var minimum = Int.MAX_VALUE
    var maximum = Int.MIN_VALUE
    var minIndex = String()
    var maxIndex = String()

    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] < minimum) {
                minimum = array[i][j]
                minIndex = "[$i] [$j]"
            }

            if (array[i][j] > maximum) {
                maximum = array[i][j]
                maxIndex = "[$i] [$j]"
            }
        }
    }
    println("минимальное значение: Array$minIndex = $minimum")
    println("Максимальное значение: Array$maxIndex = $maximum")
}


private fun changingElementsOfArray(array: Array<Array<Int>>) {
    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] % 2 == 0) {
                array[i][j] = 1
            } else {
                array[i][j] = 0
            }
        }
    }
}

private fun diagonalArray() {
    val n = 4
    val array = createTwoArrayWithZero(n)

    for (i in array.indices) {
        for (j in array[i].indices) {
            if (n - 1 - i == j) {
                array[i][j] = 1
            }

            if (n - 1 - i < j) {
                array[i][j] = 2
            }
        }
    }

    printIntTwoArray(array)
}

private fun ifDiagonalArraySymmetric() {
    val array = createIntTwoArray(scanner)
    var check = 0

    for (i in array.indices) {
        for (j in array[i].indices) {

            if (i == j) {
                check += 0
            } else if (array[i][j] == array[j][i]) {
                check += 1
            }
        }
    }

    if (check == array.size * array.size - array.size) {
        println("Да")
    } else {
        println("Нет")
    }
}

private fun work361() {
    val array = createTwoArrayWithZero(3, 4)
    var l = 1

    for (k in 0 until array.size * array[0].size) {
        val j = k % array.size
        val i = k / array[j].size
        array[j][i] = l
        l++
    }

    printIntTwoArray(array)
}

private fun snakeTwoArray() {
    val array = createTwoArrayWithZero(4)

    for (i in array.indices) {
        for (j in array[i].indices) {
            if (i % 2 == 0) {
                array[i][j] = i * array.size + j
            } else {
                array[i][j] = i * array.size + (array.size - j - 1)
            }
        }
    }

    printIntTwoArray(array)
}