package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class ScreenWithColumns(context: Context) : View(context) {
    var i = 0

    private val line: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        while (i <= height) {
            canvas?.drawLine(20F, i.toFloat(), width.toFloat() / 2 - 10f, i.toFloat() , line)
            canvas?.drawLine(width.toFloat() / 2 + 10f, i.toFloat(), width.toFloat() - 20f, i.toFloat() , line)

            i += 40
        }

    }
}