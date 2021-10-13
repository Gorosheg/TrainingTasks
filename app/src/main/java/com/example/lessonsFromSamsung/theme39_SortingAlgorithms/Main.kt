package com.example.lessonsFromSamsung.theme39_SortingAlgorithms

fun main() {
    val list = studentsList()
    val sortingArray = sortStudents(list)
    printPersons(sortingArray)
}

private fun studentsList(): ArrayList<Person> = arrayListOf(
    Person("Sveta", "Ivanova", 12),
    Person("Ivan", "Petrov", 14),
    Person("Anna", "Sidorova", 10),
    Person("Petr", "Petrov", 11)
)

private fun sortStudents(list: ArrayList<Person>): ArrayList<Person> {
    for (i in 1 until list.size) {
        when (Person.SurnameComparator().compare(list[i - 1].surname, list[i].surname)) {
            1 -> swap(list, i - 1, i)
            0 -> {
                Person.NameComparator().compare(list[i - 1].name, list[i].name)
                swap(list, i - 1, i)
            }
        }
    }
    return list
}

private fun swap(list: ArrayList<Person>, previous: Int, current: Int) {
    val container = list[previous]
    list[previous] = list[current]
    list[current] = container
}

private fun printPersons(list: ArrayList<Person>) {
    for (i in 0 until list.size) {
        printPerson(list, i)
    }
    println("")
}

private fun printPerson(list: ArrayList<Person>, index: Int) {
    val forPrint = list[index]
    println(forPrint.name + " " + forPrint.surname + " " + forPrint.age)

}


