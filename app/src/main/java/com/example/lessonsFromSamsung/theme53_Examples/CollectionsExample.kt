package com.example.lessonsFromSamsung.theme53_Examples

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
    val referenceList3: List<Int> = sourceList3
    // referenceList3.add(4) // ошибка компиляции
    sourceList3.add(4)
    println(referenceList) // [1, 2, 3, 4]

    val numbers: Set<Int> = setOf(1, 2, 3, 4, 5)
    val message: List<Int> = numbers // Новый список
        .filter { it % 2 == 0 } // [2, 4]
        .map { it * 3 } // Map применяет лямбда-выражение к каждому элементу списка
    println(message) //[6, 12]

    val numbers2: List<String> = listOf("one", "two", "three", "four")
    val message1: Map<String, Int> = numbers2.associateWith { it.length }
    println(message1) // {one=3, two=3, three=5, four=4}

    val numbers3: List<String> = listOf("one", "two", "three", "four")
    // Итератор нужен, чтобы пройтись по элементам.
    // Его можно использовать только один раз
    // listIterator можно использовать и вперед и назад по списку
    val numbersIterator: Iterator<String> = numbers3.iterator()
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

    val oddNumbers: Sequence<Int> = generateSequence(1) { it + 2 } // `it` - это предыдущее значение
    println(oddNumbers.take(5).toList()) // Take - количество элементов, которые нужно выдать. [1, 3, 5, 7, 9]
    //println(oddNumbers.count())     // ошибка: последовательность бесконечна
    //  В последовательностях нам не нужно проходить по всем элементам,
    //  мы сразу применяем все нужные операции к элементу и прекращаем операции, если цель достигнута.

    val cats = sequenceOf("Барсик", "Мурзик", "Рыжик", "Васька") // другой вариант
    // Если есть уже готовые List или Set, то их можно преобразовать в последовательность через asSequence().

    val numbers6 = listOf("one", "two", "three", "four")
    val longerThan3 = numbers6.filter { it.length > 3 }
    println(longerThan3) // [three, four]

    val filterResults = mutableListOf<String>()
    numbers6.filterTo(filterResults) { it.length > 3 } // Результат сохраняется в filterResults
    numbers6.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults) // содержит результат обеих операций - [three, four, one]

    val numbers7 = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers7.sorted() // создает новую коллекцию
    println(numbers7 == sortedNumbers)  // false
    numbers7.sort() // Меняет существующую коллекцию
    println(numbers7 == sortedNumbers)  // true

    val numbers8 = setOf(1, 2, 3)
    println(numbers8.map { it * 3 }) // [3, 6, 9] // Map применяет лямбда-выражение к каждому элементу списка
    println(numbers8.mapIndexed { idx, value -> value * idx }) // [0, 2, 6] // В параметрах есть индекс

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    // mapKeys преобразовывает ключ
    println(numbersMap.mapKeys { it.key.uppercase() }) // {KEY1=1, KEY2=2, KEY3=3, KEY11=11}
    // mapValues преобразовывает значение
    println(numbersMap.mapValues { it.value + it.key.length }) // {key1=5, key2=6, key3=7, key11=16}

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    // zip создает одну коллекцию из двух и соединяет парами элементы с одинаковыми индексами
    val newList: List<Pair<String, String>> = colors zip animals
    println(newList) // [(red, fox), (brown, bear), (grey, wolf)]
    // если одна из коллекций больше, то ее последние элементы теряются
    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals)) // [(red, fox), (brown, bear)]
    val unzip: Pair<List<String>, List<String>> = newList.unzip()
    println(unzip)// ["red", "brown", "grey"], ["fox", "bear", "wolf"]

    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    val flatten: List<Int> = numberSets.flatten() // Объединяет в один List
    println(flatten) // [1, 2, 3, 4, 5, 6, 1, 2]

    val numbers9 = listOf("one", "two", "three", "four")
    println(numbers9) // [one, two, three, four]
    println(numbers9.joinToString()) // one, two, three, four
    val listString = StringBuffer("The list of numbers: ")
    numbers9.joinTo(listString)
    println(listString) // The list of numbers: one, two, three, four

    val numbers10 = listOf("one", "two", "three", "four")
    // partition возвращает Pair<List, List>.
    // В первый  List записываются значения, удовлетворяющие условию, во второй - остальные
    val (match: List<String>, rest: List<String>) = numbers10.partition { it.length > 3 }
    println(match) // [three, four]
    println(rest) // [one, two]

    val numbers11 = listOf("one", "two", "three", "four")
    numbers11.any { it.endsWith("e") } // true - хоть один элемент соответствует условию
    numbers11.none { it.endsWith("a") } // true - все НЕ соответствуют условию
    numbers11.all { it.endsWith("e") } // false - Все соответствуют условию
    emptyList<Int>().all { it > 5 }   // true - бессмысленная истина. Если Лист пуст, то всегда True

    val numbers12 = listOf("one", "two", "three", "four", "five")
    println(numbers12.groupBy { it.first() }) // Группировка по заданному признаку - {O=[one], T=[two, three], F=[four, five]}

    val numbers13 = listOf("one", "two", "three", "four", "five", "six")
    // Slice Возвращает список элементов по индексам
    println(numbers13.slice(1..3)) // [two, three, four]
    println(numbers13.slice(0..4 step 2)) // [one, three, five]
    println(numbers13.slice(setOf(3, 5, 0))) // [four, six, one]
    // take - возвращает первые несколько элементов, takeLast - последние несколько
    println(numbers13.take(3)) // [one, two, three]
    println(numbers13.takeLast(3)) // [four, five, six]
    // Drop - возвращает список без указанного количества элементов
    println(numbers13.drop(1)) // [two, three, four, five, six]
    println(numbers13.dropLast(5)) // [one]

    val numbers14: List<Int> = (0..13).toList()
    // Функция chunked разбивает лист на несколько листов с заданным размером и возвращает лист этих листов
    val chunkedNumbers: List<List<Int>> = numbers14.chunked(3)
    println(chunkedNumbers) // [[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10, 11], [12, 13]]

    val numbers15 = setOf("one", "two", "three")
    // union - объединяет две коллекции
    println(numbers15 union setOf("four", "five")) // [one, two, three, four, five]
    println(setOf("four", "five") union numbers15) // [four, five, one, two, three]
    println(numbers15 intersect setOf("two", "one")) // [one, two] - ищет элементы, присутствующие в обоих коллекциях
    println(numbers15 subtract setOf("three", "four")) // [one, two] - ищет элементы, которых нет в обоих коллекциях

    val numbersMap2 = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap2.keys) // [one, two, three] - возвращает все ключи
    println(numbersMap2.values) // [1, 2, 3] - возвращает все значения
    println(numbersMap2.filterKeys { it.endsWith("1") }) // Фильтрация по ключам
    println(numbersMap2.filterValues { it < 10 }) // филььтрация по значениям

}
