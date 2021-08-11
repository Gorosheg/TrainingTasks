package com.example.lessonsFromSamsung.theme27_2Dgraphics.draw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class DrawingWithClicksExample(context: Context) : View(context) {

    private var startX = 0f
    private var startY = 0f

    private val rectPaint: Paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        println("onDraw")
        canvas.drawRect(startX, startY, startX + 100, startY + 100, rectPaint)
    }

    @SuppressLint("ClickableViewAccessibility") // Игнорим warning
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                println("ACTION_DOWN")
                startX = event.x
                startY = event.y
                invalidate() // Заставляем перерисоваться view, вызвать onDraw
            }

            MotionEvent.ACTION_MOVE -> {
                println("ACTION_MOVE")
            }

            MotionEvent.ACTION_UP -> {
                println("ACTION_UP")
            }
        }

        return true
    }

}