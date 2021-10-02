package com.example.lessonsFromSamsung.theme40_MultitudesHashing

import java.util.*

class Set100Int() {
    private val array: Array<Boolean> = Array(101) { false }

    fun add(e: Int): Boolean {
        return if (e > 100) false
        else {
            array[e] = true
            true
        }
    }

    fun clear() {
        Arrays.fill(array, false)
    }

    fun contains(e: Int): Boolean {
        return if (e <= 100) array[e]
        else false
    }

    fun remove(e: Int): Boolean {
        return if (e > 100) false
        else {
            array[e] = false
            true
        }
    }
}