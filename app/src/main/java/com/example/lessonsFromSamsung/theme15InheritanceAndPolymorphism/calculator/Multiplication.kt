package com.example.lessonsFromSamsung.theme15InheritanceAndPolymorphism.calculator

class Multiplication : Calculator() {

    fun askToEnterNumbers() {
        println("Введите два множителя")
    }

    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }
}