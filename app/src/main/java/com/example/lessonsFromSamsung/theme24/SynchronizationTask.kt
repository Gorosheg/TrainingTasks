package com.example.lessonsFromSamsung.theme24

private fun main() {
    val work1 = Work("A")
    val work2 = Work("B")
    val work3 = Work("C")

    work1.start()
    work2.start()
    work3.start()
}

private class Work(var threadName: String) : Thread() {

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