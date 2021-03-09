package com.example.lessonsFromSamsung.utils

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun TextView.setAppTextColor(@ColorRes resId: Int) {
    setTextColor(ContextCompat.getColor(context, resId))
}