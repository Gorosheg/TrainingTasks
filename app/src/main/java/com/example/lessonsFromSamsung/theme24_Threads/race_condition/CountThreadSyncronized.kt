package com.example.lessonsFromSamsung.theme24_Threads.race_condition

import kotlinx.coroutines.InternalCoroutinesApi
import kotlin.concurrent.thread

private var number = 0

private fun main() {
    thread(block = ::doLogic)
    thread(block = ::doLogic)
}

@OptIn(InternalCoroutinesApi::class)
private fun doLogic() {
    println(Thread.currentThread().name)

    for (i in 0..999) {
        Thread.sleep(10)

        // Если в этом блоке кто-то работает, то остальные будут ждать, пока он освободится. "Критическая секция"
        // Важно, чтобы потоки работали с одним ключом lock, есил они будут разные, то синхронизации не будет
//        incrementNumber()
        synchronized("lock") {
            number++
        }
    }

    println(number)
}

@Synchronized
private fun incrementNumber() {
    number++
}