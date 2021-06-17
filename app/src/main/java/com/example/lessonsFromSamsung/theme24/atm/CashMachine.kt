package com.example.lessonsFromSamsung.theme24.atm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_24_cash_machine.*

class CashMachine : AppCompatActivity() {

    var money: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_24_cash_machine)

        withdrawMoney.setOnClickListener {
            withdraw(money)
        }

        depositMoney.setOnClickListener {
            deposit(money)
        }

    }

    private fun withdraw(money: Int) {
        Thread {
            synchronized(money) {
                val inputTotal = inputTotal()

                if (money - inputTotal > 0) {
                    sleepWithTry()
                    for (i in 0 until inputTotal()) {
                        this.money -= 1
                    }
                } else {
                    backMessage.text = "There are no enough money on year account"
                }

                runOnUiThread {
                    checkBalance()
                }
            }
        }.start()
    }

    private fun deposit(money: Int) {
        Thread {
            synchronized(money) {
                sleepWithTry()
                for (i in 0 until inputTotal()) {
                    this.money += 1
                }

                runOnUiThread {
                    checkBalance()
                }
            }
        }.start()
    }

    private fun sleepWithTry() {
        try {
            Thread.sleep((100 * Math.random()).toLong())
        } catch (e: InterruptedException) {
        }
    }

    private fun checkBalance() {
        backMessage.text = money.toString()
    }

    private fun inputTotal(): Int {
        return if (inputAmount.text.isNotEmpty()) {
            getCurrentInput()
        } else {
            0
        }
    }

    private fun getCurrentInput() = inputAmount.text.toString().toInt()

}