package com.example.lessonsFromSamsung.utils

import android.widget.TextView
import androidx.annotation.ColorRes

/**
 * Устанавливает цвет текста по id ресурса цвета
 */
fun TextView.setAppTextColor(@ColorRes resId: Int) {
    setTextColor(context.getAppColor(resId))
}