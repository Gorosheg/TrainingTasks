package com.example.lessonsFromSamsung

import java.util.*

fun main() {
    val sizeOfField = 8
    val field: MutableList<MutableList<Char>> = createList(sizeOfField)
    val fieldWithCrosses = addCrosses(field, sizeOfField)
    printField(sizeOfField, fieldWithCrosses)

}

private fun addCrosses(field: MutableList<MutableList<Char>>, sizeOfField: Int): MutableList<MutableList<Char>> {
    val random = Random()
    for (i in 0..sizeOfField + 1) {
        val line: MutableList<Char> = field[random.nextInt(sizeOfField)]
        val randomElement: Int = random.nextInt(sizeOfField)
        line[randomElement] = 'x'
    }

    return field
}

private fun createList(sizeOfField: Int): MutableList<MutableList<Char>> {
    val outerList: MutableList<MutableList<Char>> = mutableListOf()
    for (i in 0..sizeOfField) {
        outerList.add(fillField(sizeOfField))
    }
    return outerList
}

private fun fillField(sizeOfField: Int): MutableList<Char> {
    val innerList = mutableListOf<Char>()
    for (j in 0..sizeOfField) {
        innerList.add('.')
    }
    return innerList
}

private fun printField(
    sizeOfField: Int,
    field: MutableList<MutableList<Char>>
) {
    for (i in 0..sizeOfField) {
        for (element in field[i]) {
            print(element)
        }
        println()
    }
}
