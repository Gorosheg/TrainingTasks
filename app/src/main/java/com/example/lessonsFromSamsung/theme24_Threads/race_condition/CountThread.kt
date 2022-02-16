package com.example.lessonsFromSamsung.theme24_Threads.race_condition

import kotlin.concurrent.thread

//@Volatile
private var number = 0

private fun main() {
    thread(block = ::doLogic)
    thread(block = ::doLogic)
}

private fun doLogic() {
    println(Thread.currentThread().name)

    for (i in 0..999) {
        Thread.sleep(10)
        number++
    }

    println(number)
}