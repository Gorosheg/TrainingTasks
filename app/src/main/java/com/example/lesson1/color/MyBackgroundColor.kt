package com.example.lesson1.color

import androidx.annotation.ColorRes
import com.example.lesson1.R

enum class MyBackgroundColor(@ColorRes val colorRes: Int) {

    RED(R.color.red),
    GREEN(R.color.green),
    YELLOW(R.color.yellow),
    BLUE(R.color.blue),
    WHITE(R.color.white)

}