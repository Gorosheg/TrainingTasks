package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawLine

class ScreenWithColumns(context: Context) : View(context) {

    // Review: private
    var i = 0

    // Review: rename
    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        while (i <= height) {
            canvas.drawLeftHorizontalLine()
            canvas.drawRightHorizontalLine()

            i += 40
        }

    }

    // Review: Extract other function like this one (in all views)
    private fun Canvas.drawLeftHorizontalLine() = drawLine(
        startX = 20,
        startY = i,
        stopX = width / 2 - 10,
        stopY = i,
        paint = line
    )

    private fun Canvas.drawRightHorizontalLine() = drawLine(
        startX = width / 2 + 10,
        startY = i,
        stopX = width - 20,
        stopY = i,
        paint = line
    )
}