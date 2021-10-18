package com.example.lessonsFromSamsung

fun main() {
    val sourceList = listOf(1, 2, 3)
    val referenceList = sourceList.toMutableSet() // Новый сет
    referenceList.add(3)
    referenceList.add(4)
    println(sourceList) // [1, 2, 3]
    println(referenceList) // [1, 2, 3, 4]

    val sourceList2 = mutableListOf(1, 2, 3)
    val referenceList2 = sourceList2 // Ссылка
    referenceList2.add(4) // Изменения касаются всех ссылок на колекцию
    println(sourceList2) // [1, 2, 3, 4]

    val sourceList3 = mutableListOf(1, 2, 3)
    val referenceList3: List<Int> = sourceList
    // referenceList3.add(4) // ошибка компиляции
    sourceList3.add(4)
    println(referenceList) // [1, 2, 3, 4]

    val numbers: Set<Int> = setOf(1, 2, 3, 4, 5)
    val message: List<Int> = numbers // Новый список
        .filter { it % 2 == 0 } // [2, 4]
        .map { it * 3 }
    println(message) //[6, 12]

    val numbers2: List<String> = listOf("one", "two", "three", "four")
    val message1: Map<String, Int> = numbers2.associateWith { it.length }
    println(message1) // {one=3, two=3, three=5, four=4}

    val numbers3: List<String> = listOf("one", "two", "three", "four")
    // Итератор нужен, чтобы пройтись по элементам.
    // Его можно использовать только один раз
    val numbersIterator: Iterator<String> = numbers3.iterator() // listIterator можно использовать и вперед и назад по списку
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
    /* Аналогичные примеры:
       for (item in numbers3) {
        println(item)
    }
    numbers3.forEach {
        println(it)
    }
     */

    val numbers4 = mutableListOf("one", "two", "three", "four")
    val mutableIterator = numbers4.iterator()

    mutableIterator.next()
    mutableIterator.remove()
    println("After removal: $numbers4") // [two, three, four]


    val numbers5 = mutableListOf("one", "four", "four")
    val mutableListIterator = numbers5.listIterator()
    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println(numbers5) // [one, two, three, four]

    val oddNumbers = generateSequence(1) { it + 2 } // `it` - это предыдущее значение
    println(oddNumbers.take(5).toList()) // Take - количество элементов, которые нужно выдать. [1, 3, 5, 7, 9]
    //println(oddNumbers.count())     // ошибка: последовательность бесконечна
}
