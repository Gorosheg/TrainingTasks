package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class DrawWithClicks(context: Context) : View(context) {

    // Создаем MutableList с классом Pair в котором два элемента(типа Float), в данном случае точки X и Y
    private val clicks: MutableList<Pair<Float, Float>> = mutableListOf()

    private val greenPaint: Paint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.GREEN
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        //  goThroughRectArray(canvas)
        goThroughLineArray(canvas)
    }

    private fun goThroughLineArray(canvas: Canvas) {
        if (clicks.size > 1) {
            for (i in 1 until clicks.size) {
                giveArgumentsForDrawing(i, canvas)
            }
        }
    }

    private fun goThroughRectArray(canvas: Canvas) {
        clicks.forEach { (x, y) -> // X и Y - элементы массива, их можно назвать как угодно
            drawRect(canvas, x, y)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> {
                val pair = Pair(event.x, event.y) // Создаем пару из координат точки клика
                clicks.add(pair) // С помощью add добавляем пару в массив
                invalidate() // Запускается метод onDraw повторно
            }
        }
        return true
    }

    private fun giveArgumentsForDrawing(i: Int, canvas: Canvas) {
        val currentClick = clicks[i]
        val (previousX, previousY) = clicks[i - 1]
        drawLine(canvas, currentClick.first, currentClick.second, previousX, previousY)
    }

    private fun drawRect(canvas: Canvas, x: Float, y: Float) {
        canvas.drawRect(x - A, y - A, x + A, y + A, greenPaint)
    }

    private fun drawLine(canvas: Canvas, x: Float, y: Float, previousX: Float, previousY: Float) {
        canvas.drawLine(previousX, previousY, x, y, greenPaint)
    }

    companion object {
        private const val A = 50
    }
}