package com.example.lessonsFromSamsung.theme15_InheritanceAndPolymorphism.calculator

class Subtraction : Calculator() {

    fun askToEnterNumbers() {
        println("Введите уменьшаемое и вычитаемое")
    }

    fun minus(a: Int, b: Int): Int {
        return a - b
    }
}