package com.example.lessonsFromSamsung.theme27_2Dgraphics.ticTacToe

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import com.example.lessonsFromSamsung.utils.createArrayWithZero

class TicTacToeDraw(context: Context) : View(context) {

    private val array = createArrayWithZero(9)
    private var pointX = 0f // TODO: делаем локальными и передаём в функцию параметром
    private var pointY = 0f // TODO: делаем локальными и передаём в функцию параметром
    private var queue = true

    private val linePaint: Paint = Paint().apply { // TODO: Use buildPaint
        style = Paint.Style.STROKE
        color = Color.GRAY
        strokeWidth = 7f
    }

    private val crossLinePaint: Paint = buildPaint(Color.BLUE)

    private val circlePaint: Paint = Paint().apply { // TODO: Use buildPaint
        style = Paint.Style.STROKE
        color = Color.RED
        strokeWidth = 7f
    }

    private fun buildPaint(@ColorInt color: Int): Paint {
        return Paint().apply {
            style = Paint.Style.STROKE
            this.color = color
            strokeWidth = 7f
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        drawGrid(canvas)
        drawFigures(canvas)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val pair = Pair(event.x, event.y)
                attachFigureToCell(pair)
                invalidate()
            }
        }

        return true
    }

    private fun attachFigureToCell(pair: Pair<Float, Float>) {
        val x = (pair.first / C).toInt()
        val y = ((pair.second - C) / C).toInt()
        val index = 3 * y + x
        array[index] = if (queue) 1 else 2
        queue = !queue
    }

    private fun drawFigures(canvas: Canvas) {
        for (i in array.indices) {
            if (array[i] != 0) {
                writeCoordinates(i, canvas)
            }
        }
    }

    private fun writeCoordinates(i: Int, canvas: Canvas) { // TODO: drawFigure
        val line = i / 3
        val column = i % 3

        pointX = when (column) {
            0 -> A
            1 -> C
            2 -> D
            else -> A
        }

        pointY = when (line) {
            0 -> C
            1 -> D
            2 -> E
            else -> A
        }

        if (array[i] == 1) {
            drawCross(canvas)
        } else if (array[i] == 2) {
            drawCircle(canvas)
        }
    }

    private fun drawCross(canvas: Canvas) {
        drawLine(pointX, pointY, pointX + C, pointY + C, canvas, crossLinePaint)
        drawLine(pointX + C, pointY, pointX, pointY + C, canvas, crossLinePaint)
    }

    private fun drawCircle(canvas: Canvas) {
        canvas.drawCircle(pointX + B, pointY + B, B, circlePaint)
    }

    private fun drawGrid(canvas: Canvas) {
        drawLine(C, C, C, F, canvas, linePaint)
        drawLine(D, C, D, F, canvas, linePaint)
        drawLine(A, D, E, D, canvas, linePaint)
        drawLine(A, E, E, E, canvas, linePaint)
    }

    private fun drawLine(startX: Float, startY: Float, stopX: Float, stopY: Float, canvas: Canvas, linePaint: Paint) {
        canvas.drawLine(startX, startY, stopX, stopY, linePaint)
    }

    companion object {

        private const val A = 0f
        private const val B = 175f
        private const val C = 350f
        private const val D = 700f
        private const val E = 1050f
        private const val F = 1400f

    }

}