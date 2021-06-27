package com.example.lessonsFromSamsung.theme27_2Dgraphics.util

import android.graphics.Canvas
import android.graphics.Paint

fun Canvas.drawLine(startX: Int, startY: Int, stopX: Int, stopY: Int, paint: Paint) {
    drawLine(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)
}

fun Canvas.drawRect(startX: Int, startY: Int, stopX: Int, stopY: Int, paint: Paint) {
    drawRect(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)
}