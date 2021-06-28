package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class DrawWithClicksExample(context: Context) : View(context) {

    /*
    TODO: Хранить нажатия в массиве list: MutableList<Pair<Float, Float>>
      по клику добавлять элемент в массив
      в onDraw рисовать клики в цикле list.forEach { pair ->  } // pair.first, pair.second
     */

    // TODO: Рисовать не прямоугольники а линии, которые будут соединяться с последней позицией нажатия

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