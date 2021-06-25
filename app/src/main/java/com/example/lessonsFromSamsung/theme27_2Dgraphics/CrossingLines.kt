package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CrossingLines(context: Context) : View(context) {

    // Review: greenPaint
    private val line1: Paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }

    // Review: bluePaint
    private val line2: Paint = Paint().apply {
        color = Color.BLUE
        // Review: STROKE
        style = Paint.Style.FILL
        strokeWidth = 10F
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(0F, 0F, width.toFloat(), height.toFloat(), line1)
        canvas?.drawLine(width.toFloat(), 0f, 0f, height.toFloat(), line2)
    }

}