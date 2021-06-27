package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawLine

class CrossingLines(context: Context) : View(context) {

    private val greenLinePaint: Paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }

    private val blueLinePaint: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.leftDiagonalLine()
        canvas.rightDiagonalLine()
    }

    private fun Canvas.leftDiagonalLine() = drawLine(
        startX = 0,
        startY = 0,
        stopX = width,
        stopY = height,
        paint = greenLinePaint
    )

    private fun Canvas.rightDiagonalLine() = drawLine(
        startX = width,
        startY = 0,
        stopX = 0,
        stopY = height,
        paint = blueLinePaint
    )
}