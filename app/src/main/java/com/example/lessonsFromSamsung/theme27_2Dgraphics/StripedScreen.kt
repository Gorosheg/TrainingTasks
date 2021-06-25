package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class StripedScreen(context: Context) : View(context) {

    var i = 0
    var j = 0
    private val line: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE

    }

    // горизонтальные полоски
    /* override fun onDraw(canvas: Canvas?) {
         super.onDraw(canvas)

         // Review: Extract to fun
         while (i <= height) {
             canvas?.drawLine(0F, i.toFloat(), width.toFloat(), i.toFloat(), line)
             i += 40
         }
     }*/

    // диаганальные полоски
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Review: Extract to fun
        while (i <= height) {
            canvas?.drawLine(j.toFloat(), 0F, width.toFloat() + j.toFloat(), height.toFloat(), line)
            canvas?.drawLine(0F, i.toFloat(), width.toFloat(), height.toFloat() + i.toFloat(), line)

            i += 70
            j += 40
        }
    }

}