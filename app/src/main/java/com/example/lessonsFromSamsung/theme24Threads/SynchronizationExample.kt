package com.example.lessonsFromSamsung.theme24Threads

private fun main() {

}

@Synchronized
private fun synchronizedFun() {

}

object SynchronizationExample{

    private fun synchronizedBlockInFun() {
        // Some code

        synchronized(this) { // требует 1м параметром lock, тут это this. У статических функций this'а класса нет - они ведь вне класса
            // Some sync code
        }
    }

}
