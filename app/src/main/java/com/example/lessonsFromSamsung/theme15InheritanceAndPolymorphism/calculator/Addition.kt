package com.example.lessonsFromSamsung.theme15InheritanceAndPolymorphism.calculator

class Addition : Calculator() {

    fun askToEnterNumbers() {
        println("Введите два слагаемых")
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }
}