package com.example.lessonsFromSamsung.theme39_SortingAlgorithms

class Person(
    val name: String,
    val surname: String,
    val age: Int
) {
    class NameComparator : Comparator<String> {

        override fun compare(n1: String, n2: String): Int {
            return when {
                n1 == n2 -> 0
                n1 > n2 -> 1
                else -> -1
            }
        }

    }

    class SurnameComparator : Comparator<String> {
        override fun compare(s1: String, s2: String): Int {
            return when {
                s1 == s2 -> 0
                s1 > s2 -> 1
                else -> -1
            }
        }
    }

}