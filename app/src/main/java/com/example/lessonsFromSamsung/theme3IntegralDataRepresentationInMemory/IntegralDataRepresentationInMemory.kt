package com.example.lessonsFromSamsung.theme3IntegralDataRepresentationInMemory

import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    work2941()
}

// Вывод последней цифры числа
fun work2941() {
    val inValue = scanner.nextInt()

    val outValue = inValue % 10
    println(outValue)
}

// Вывод первой цифры числа
fun work2942() {
    val inValue = scanner.nextInt()

    val outValue = inValue / 100
    println(outValue)
}

// Вывод суммы чисел трехзначного числа
fun work2944() {
    val inValue = scanner.nextInt()

    val outValue = (inValue / 100) + (inValue % 10) + ((inValue / 10) % 10)
    println(outValue)
}

// Вывод следующего четного числа
fun work2945() {
    val inValue = scanner.nextInt()

    val outValue = inValue / 2 * 2 + 2
    println(outValue)
}

// Вывод часов и минут от начала дня по известному количеству прошедших минут
fun work2947() {
    val inValue = scanner.nextInt()
    val inValueWithoutDays = inValue % (24 * 60)

    val hours = inValueWithoutDays / 60
    val minutes = inValueWithoutDays % 60
    print("$hours ")
    print(minutes)
}

// Найти крайние месяцы по кварталу
fun findMonthsByQuarter() {
    val inValue = scanner.nextInt()

    val lastMonth = inValue * 3
    val firstMonth = lastMonth - 2
    println(firstMonth)
    println(lastMonth)
}

// Найти квартал по месяцу
fun findQuarterByMonth() {
    val inValue = scanner.nextInt()

    val quarter = (inValue + 2) / 3
    println(quarter)
}

// Сдвиг крайних правых битов
fun work121() {
    val inValue1 = scanner.nextInt()
    val inValue2 = scanner.nextInt()

    val outValue = (inValue1 shr inValue2) shl inValue2
    println(outValue)
}

// 2^n
fun work123() {
    val inValue2 = scanner.nextInt()

    val outValue = 1 shl inValue2
    println(outValue)
}