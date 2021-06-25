package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Cube(context: Context) : View(context) {

    // Review: Move to companion
    // Review: Give adecvatnie names. startX, startY, or left, top ...
    private val b = 300f
    private val c = 500f
    private val d = 700f
    private val e = 950f
    private val f = 1150f
    private var i = 0f

    // Review: blackPaint
    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Review: Use drawRect
        // Review: Extract to fun
        canvas?.drawLine(A, c, A, height - f, line)
        canvas?.drawLine(A, c, width - c, c, line)
        canvas?.drawLine(b, d, b, height - e, line)
        canvas?.drawLine(b, d, width - b, d, line)
        canvas?.drawLine(b, height - e, width - b, height - e, line)
        canvas?.drawLine(width - b, d, width - b, height - e, line)
        canvas?.drawLine(A, height - f, b, height - e, line)
        canvas?.drawLine(A, c, b, d, line)
        canvas?.drawLine(width - c, c, width - b, d, line)

        // Review: Extract to fun
        while (i <= 200f) {
            canvas?.drawLine(A + i, c + i, width - c + i, c + i, line)
            canvas?.drawLine(A + i, c + i, A + i, height - f + i, line)
            i += 20f
        }

        // Review: Extract to fun
        i = 0f
        while (i <= 450f) {
            canvas?.drawLine(width - b, d + i, b + i, height - e, line)
            canvas?.drawLine(width - b - i, d, b, height - e - i, line)

            i += 40f
        }
    }

    companion object {

        private const val A = 100f

    }

}