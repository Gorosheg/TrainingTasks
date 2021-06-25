package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Cube(context: Context) : View(context) {

    private val a = 100f
    private val b = 300f
    private val c = 500f
    private val d = 700f
    private val e = 950f
    private val f = 1150f
    private var i = 0f

    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(a, c, a, height - f, line)
        canvas?.drawLine(a, c, width - c, c, line)
        canvas?.drawLine(b, d, b, height - e, line)
        canvas?.drawLine(b, d, width - b, d, line)
        canvas?.drawLine(b, height - e, width - b, height - e, line)
        canvas?.drawLine(width - b, d, width - b, height - e, line)
        canvas?.drawLine(a, height - f, b, height - e, line)
        canvas?.drawLine(a, c, b, d, line)
        canvas?.drawLine(width - c, c, width - b, d, line)

        while (i <= 200f) {
            canvas?.drawLine(a + i, c + i, width - c + i, c + i, line)
            canvas?.drawLine(a + i, c + i, a + i, height - f + i, line)
            i += 20f
        }

        i = 0f
        while (i <= 450f) {
            canvas?.drawLine(width - b, d + i, b + i, height - e, line)
            canvas?.drawLine(width - b - i, d, b, height - e - i, line)

            i += 40f
        }
    }

}