package com.example.lessonsFromSamsung.utils

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Достаёт цвет из ресурсов по id с помощью контекста
 */
fun Context.getAppColor(@ColorRes resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}