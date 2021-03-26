package com.example.lessonsFromSamsung.theme24

class Work(var threadName: String) : Thread() {
    override fun run() {
        val max = (20 * Math.random()).toInt()
        for (i in 0 until max) {
            try {
                sleep((1000 * Math.random()).toLong())
                print(threadName)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}