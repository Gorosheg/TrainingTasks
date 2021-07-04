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

    private var array = createArrayWithZero(9)
    private var queue = true

    private val linePaint: Paint = buildPaint(Color.GRAY)
    private val crossLinePaint: Paint = buildPaint(Color.BLUE)
    private val circlePaint: Paint = buildPaint(Color.RED)
    private var vins: Boolean = false

    private fun buildPaint(@ColorInt color: Int): Paint { // Аннотация нужна, чтобы получить цвет, а не просто Int
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
                if (vins) {
                    array = createArrayWithZero(9)
                    vins = false
                }
                invalidate()

            }
        }

        return true
    }

    private fun attachFigureToCell(pair: Pair<Float, Float>) {
        val x = (pair.first / C).toInt()
        val y = ((pair.second - C) / C).toInt()
        val index = 3 * y + x

        if (array[index] == 0) {
            array[index] = if (queue) 1 else 2
            queue = !queue
        }

    }

    private fun drawFigures(canvas: Canvas) {
        for (i in array.indices) {
            if (array[i] != 0) {
                drawFigure(i, canvas)
            }
        }
    }

    private fun drawFigure(i: Int, canvas: Canvas) {

        val pointX = when (i % 3) {
            0 -> A
            1 -> C
            2 -> D
            else -> A
        }

        val pointY = when (i / 3) {
            0 -> C
            1 -> D
            2 -> E
            else -> A
        }

        if (array[i] == 1) {
            drawCross(canvas, pointX, pointY)
        } else if (array[i] == 2) {
            drawCircle(canvas, pointX, pointY)
        }
    }

    private fun checkForWin(canvas: Canvas) {
        when {

            areSimilarFigures(0, 1, 2) -> {
                drawLine(A, C + B, E, C + B, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(3, 4, 5) -> {
                drawLine(A, D + B, E, D + B, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(6, 7, 8) -> {
                drawLine(A, E + B, E, E + B, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(0, 3, 6) -> {
                drawLine(B, C, B, F, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(1, 4, 7) -> {
                drawLine(C + B, C, C + B, F, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(2, 5, 8) -> {
                drawLine(D + B, C, D + B, F, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(0, 4, 8) -> {
                drawLine(A, C, E, F, canvas, linePaint)
                vins = true
            }

            areSimilarFigures(2, 4, 6) -> {
                drawLine(E, C, A, F, canvas, linePaint)
                vins = true
            }

        }
    }

    private fun areSimilarFigures(
        a: Int,
        b: Int,
        c: Int
    ): Boolean {
        return (array[a] != 0 && array[a] == array[b] && array[b] == array[c])
    }

    private fun drawCross(canvas: Canvas, pointX: Float, pointY: Float) {
        drawLine(pointX, pointY, pointX + C, pointY + C, canvas, crossLinePaint)
        drawLine(pointX + C, pointY, pointX, pointY + C, canvas, crossLinePaint)
    }

    private fun drawCircle(canvas: Canvas, pointX: Float, pointY: Float) {
        canvas.drawCircle(pointX + B, pointY + B, B, circlePaint)
    }

    private fun drawGrid(canvas: Canvas) {
        drawLine(C, C, C, F, canvas, linePaint)
        drawLine(D, C, D, F, canvas, linePaint)
        drawLine(A, D, E, D, canvas, linePaint)
        drawLine(A, E, E, E, canvas, linePaint)
    }

    private fun drawLine(
        startX: Float,
        startY: Float,
        stopX: Float,
        stopY: Float,
        canvas: Canvas,
        linePaint: Paint
    ) {
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

