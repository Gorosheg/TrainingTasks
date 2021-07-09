package com.example.lessonsFromSamsung.theme27_2Dgraphics.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawLine
import com.example.lessonsFromSamsung.theme27_2Dgraphics.util.drawRect

class Cube(context: Context) : View(context) {

    private var i = 0

    // Review: blackPaint
    private val blackLinePaint: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCentralRect()
        canvas.drawBackVerticalLine()
        canvas.drawBackHorizontalLine()
        canvas.drawDiagonalLine(A, height - F, B, height - E)
        canvas.drawDiagonalLine(A, C, B, D)
        canvas.drawDiagonalLine(width - C, C, width - B, D)

        drawBackSidesHatching(canvas)
        drawFrontSideHatching(canvas)
    }

    private fun Canvas.drawCentralRect() = drawRect(
        startX = B,
        startY = D,
        stopX = width - B,
        stopY = height - E,
        paint = blackLinePaint
    )

    private fun Canvas.drawBackVerticalLine() = drawLine(
        startX = A,
        startY = C,
        stopX = A,
        stopY = height - F,
        paint = blackLinePaint
    )

    private fun Canvas.drawBackHorizontalLine() = drawLine(
        startX = A,
        startY = C,
        stopX = width - C,
        stopY = C,
        paint = blackLinePaint
    )

    private fun Canvas.drawDiagonalLine(startX: Int, startY: Int, stopX: Int, stopY: Int) = drawLine(
        startX = startX,
        startY = startY,
        stopX = stopX,
        stopY = stopY,
        paint = blackLinePaint
    )

    private fun drawBackSidesHatching(canvas: Canvas) {
        while (i <= 200f) {
            canvas.drawLine(
                startX = A + i,
                startY = C + i,
                stopX = width - C + i,
                stopY = C + i,
                paint = blackLinePaint
            )
            canvas.drawLine(
                startX = A + i,
                startY = C + i,
                stopX = A + i,
                stopY = height - F + i,
                paint = blackLinePaint
            )
            i += 20
        }
    }

    private fun drawFrontSideHatching(canvas: Canvas) {
        i = 0
        while (i <= 450f) {
            canvas.drawLine(
                startX = width - B,
                startY = D + i,
                stopX = B + i,
                stopY = height - E,
                paint = blackLinePaint
            )
            canvas.drawLine(
                startX = width - B - i,
                startY = D,
                stopX = B,
                stopY = height - E - i,
                paint = blackLinePaint
            )

            i += 40
        }
    }

    companion object {
        private const val A = 100
        private const val B = 300
        private const val C = 500
        private const val D = 700
        private const val E = 950
        private const val F = 1150
    }

}