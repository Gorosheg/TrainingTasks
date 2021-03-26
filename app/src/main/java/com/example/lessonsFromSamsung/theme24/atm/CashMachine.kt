package com.example.lessonsFromSamsung.theme24.atm

import com.example.lessonsFromSamsung.utils.scanner

private fun main() {
    var scanner = scanner.nextInt()
    withdrawMoney(scanner)
    depositMoney(scanner)
}

private fun withdrawMoney(scanner: Int) {
    var money = scanner

    synchronized(money) {
        if (money - 70 > 0) {
            try {
                Thread.sleep((1000 * Math.random()).toLong())
            } catch (e: InterruptedException) {
            }
            money -= 70
            println(money)
        } else println("There are no enough money on year account")
    }
}

private fun depositMoney(scanner: Int) {
    var money = scanner

    synchronized(money) {
        try {
            Thread.sleep((1000 * Math.random()).toLong())
        } catch (e: InterruptedException) {
        }
        money += money
        println(money)
    }

}