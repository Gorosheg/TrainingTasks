package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawLine

class Spiral(context: Context) : View(context) {

    var yy = 500
    var xx = 100

    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var count = 0
        while (count <= 2) {
            canvas?.drawLeftVerticalLine()
            canvas?.drawRightVerticalLine()
            canvas?.drawLeftHorizontalLine()
            canvas?.drawRightHorizontalLine()
            count += 1
            yy += 200
            xx += 150

        }
    }

    private fun Canvas.drawLeftVerticalLine() = drawLine(
        startX = xx,
        startY = yy,
        stopX = xx,
        stopY = height - yy,
        paint = line
    )

    private fun Canvas.drawRightVerticalLine() = drawLine(
        startX = xx,
        startY = yy,
        stopX = width - xx - 150,
        stopY = yy,
        paint = line
    )

    private fun Canvas.drawLeftHorizontalLine() = drawLine(
        startX = xx,
        startY = height - yy,
        stopX = width - xx,
        stopY = height - yy,
        paint = line
    )

    private fun Canvas.drawRightHorizontalLine() = drawLine(
        startX = width - xx,
        startY = yy - 200,
        stopX = width - xx,
        stopY = height - yy,
        paint = line
    )
}