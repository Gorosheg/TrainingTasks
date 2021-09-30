package com.example.lessonsFromSamsung.theme39_SortingAlgorithms

class Person(
    name: String,
    surname: String,
    age: Int
) {
    class NameComparator : Comparator<String> {

        override fun compare(o1: String, o2: String): Int {
            return when {
                o1 == o2 -> 0
                o1 > o2 -> 1
                else -> -1
            }
        }

    }
}