package com.example.lessonsFromSamsung.theme27_2Dgraphics.util

import android.graphics.Canvas
import android.graphics.Paint

// Review: Use in all cases
// Review: Add drawRect and etc and use
fun Canvas.drawLine(startX: Int, startY: Int, stopX: Int, stopY: Int, paint: Paint) {
    drawLine(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)
}