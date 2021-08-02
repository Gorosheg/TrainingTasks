package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_27_password_strenght.*

class PasswordStrength : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_27_password_strenght)

        passwordField.addTextChangedListener { checkStrength() }
    }

    private fun checkStrength() {
        val password = passwordField.text.toString()
        val countSymbols = password.count()
        val array = password.toCharArray()

        countNumbersAndLetters(array, countSymbols)
    }

    private fun countNumbersAndLetters(array: CharArray, countSymbols: Int) {
        var countLetters = 0
        var countNumbers = 0

        array.forEach {
            val symbol = it.toString()
            val v = symbol.toIntOrNull()

            if (it.code in 65..90) countLetters += 1
            else if (v != null) countNumbers += 1
        }

        strength(countSymbols, countLetters, countNumbers)
    }

    private fun strength(
        countSymbols: Int,
        countLetters: Int,
        countNumbers: Int
    ) {
        if (
            countSymbols >= 8 &&
            countLetters > 3 &&
            countNumbers > 3
        ) {
            return displayStrength(4)
        }

        if (
            countSymbols > 5 &&
            countLetters > 3 &&
            countNumbers >= 2
        ) {
            return displayStrength(3)
        }

        if (
            countSymbols > 3 &&
            (countLetters < 2 || countNumbers < 2)
        ) {
            return displayStrength(2)
        }

        if (
            countSymbols < 3 ||
            countLetters < 3 ||
            countNumbers < 1
        ) {
            return displayStrength(1)
        }
    }

    private fun displayStrength(strength: Int) {
        result.text = when (strength) {
            1 -> "Надежность 1: Очень слабый пароль."
            2 -> "Надежность 2: Слабый пароль."
            3 -> "Надежность 3: Сложный пароль."
            4 -> "Надежность 4: Очень сложный пароль."
            else -> ""
        }
    }
}