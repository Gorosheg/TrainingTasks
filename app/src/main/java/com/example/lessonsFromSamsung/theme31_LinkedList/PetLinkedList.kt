package com.example.lessonsFromSamsung.theme31_LinkedList

import java.util.*

private fun main() {
    val pets: LinkedList<Pet> = petLinkedList()
    runThroughList(pets)

}

private fun petLinkedList(): LinkedList<Pet> {
    val list: LinkedList<Pet> = LinkedList<Pet>()
    list.add(
        Pet(
            "Шарик",
            5,
            "Dog"
        )
    )
    list.add(
        Pet(
            "Буренка",
            1,
            "Caw"
        )
    )
    list.add(
        Pet(
            "Мурзик",
            3,
            "Cat"
        )
    )
    list.add(
        Pet(
            "Бобик",
            8,
            "Dog"
        )
    )
    list.add(
        Pet(
            "Кошь",
            2,
            "Cat"
        )
    )
    return list
}

private fun runThroughList(petLinkedList: LinkedList<Pet>) {
    var oldest = ""
    var dogsCount = 0
    var shortestNameCat = ""
    val catsList: LinkedList<Pet> = LinkedList<Pet>()

    for (i in 1 until petLinkedList.size) {
        if (petLinkedList[i].age > petLinkedList[i - 1].age) {
            oldest = petLinkedList[i - 1].name
        }

        if (petLinkedList[i - 1].type == "Dog") {
            dogsCount += 1
        }
        if (i == 1 && petLinkedList[i - 1].type == "Cat") {
            catsList.add(petLinkedList[i])
        }

        if (petLinkedList[i].type == "Cat") {
            catsList.add(petLinkedList[i])
        }
    }

    for (i in 1 until catsList.size) {
        if (catsList[i].name.length < catsList[i - 1].name.length) {
            shortestNameCat = catsList[i].name
        }
    }

    println(oldest)
    println(dogsCount)
    println(shortestNameCat)

    // Short kotlin way
    val petWithMaxAge = petLinkedList.maxByOrNull { it.age }
}