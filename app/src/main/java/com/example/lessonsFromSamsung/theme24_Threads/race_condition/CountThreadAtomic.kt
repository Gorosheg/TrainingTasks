package com.example.lessonsFromSamsung.theme24_Threads.race_condition

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

private val number = AtomicInteger()

private fun main() {
    thread(block = ::doLogic)
    thread(block = ::doLogic)
}

private fun doLogic() {
    println(Thread.currentThread().name)

    for (i in 0..999) {
        Thread.sleep(10)
        number.getAndIncrement()
    }

    println(number.get())
}