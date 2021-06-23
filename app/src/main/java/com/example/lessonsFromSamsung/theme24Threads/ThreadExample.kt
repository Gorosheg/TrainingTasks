package com.example.lessonsFromSamsung.theme24Threads

private fun main() {
    println("1 Thread: ${Thread.currentThread()}")

    Thread {
        println("2 Thread: ${Thread.currentThread()}")
    }.start()

    Thread {
        println("3 Thread: ${Thread.currentThread()}")
    }.start()

    println("4 Thread: ${Thread.currentThread()}")
}