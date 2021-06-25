package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Spiral(context: Context) : View(context) {

    var yy = 500f
    var xx = 100f

    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var count = 0
        while (count <= 2) {
            canvas?.drawLine(xx, yy, xx, height - yy, line)
            canvas?.drawLine(xx, yy, width - xx - 150f, yy, line)
            canvas?.drawLine(xx, height - yy, width - xx, height - yy, line)
            canvas?.drawLine(width - xx, yy - 200f, width - xx, height - yy, line)
            count += 1
            yy += 200f
            xx += 150f

        }
    }
}