package com.example.lessonsFromSamsung.theme15InheritanceAndPolymorphism.calculator

class Division : Calculator() {

    fun askToEnterNumbers() {
        println("Введите делимое и делитель")
    }

    fun division(a: Int, b: Int): Int {
        return a / b
    }
}