package com.example.lessonsFromSamsung.theme27_2Dgraphics.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawLine

class StripedScreen(context: Context) : View(context) {

    var i = 0
    var j = 0
    private val line: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        horizontalLines(canvas)
        diagonalStripes(canvas)
    }

    private fun horizontalLines(canvas: Canvas) {
        while (i <= height) {
            canvas.drawHorizontalLine()
            i += 40
        }
    }

    private fun diagonalStripes(canvas: Canvas) {
        while (i <= height) {
            canvas.drawRightDiagonalStripe()
            canvas.drawLeftDiagonalStripe()

            i += 70
            j += 40
        }
    }

    private fun Canvas.drawHorizontalLine() = drawLine(
        startX = 0,
        startY = i,
        stopX = width,
        stopY = i,
        paint = line
    )

    private fun Canvas.drawRightDiagonalStripe() = drawLine(
        startX = j,
        startY = 0,
        stopX = width + j,
        stopY = height,
        paint = line
    )

    private fun Canvas.drawLeftDiagonalStripe() = drawLine(
        startX = 0,
        startY = i,
        stopX = width,
        stopY = height + i,
        paint = line
    )
}