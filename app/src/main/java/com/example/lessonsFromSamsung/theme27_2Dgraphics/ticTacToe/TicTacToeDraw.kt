package com.example.lessonsFromSamsung.theme27_2Dgraphics.ticTacToe

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.example.lessonsFromSamsung.utils.createArrayWithZero

class TicTacToeDraw(context: Context) : View(context) {

    private val clicks: MutableList<Pair<Float, Float>> = mutableListOf()
    private val array = createArrayWithZero(9)
    private var pointX = 0f
    private var pointY = 0f
    private var queue = true

    private val linePaint: Paint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.GRAY
        strokeWidth = 7f
    }

    private val crossLinePaint: Paint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLUE
        strokeWidth = 7f
    }

    private val circlePaint: Paint = Paint().apply {
        isAntiAlias
        style = Paint.Style.STROKE
        color = Color.RED
        strokeWidth = 7f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        drawGrid(canvas)
        findCoordinates()
        drawCross(canvas)
        drawCircle(canvas)
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val pair = Pair(event.x, event.y)
                clicks.add(pair)
                findIndex(pair)
                invalidate()
            }
        }
        return true
    }

    private fun findIndex(pair: Pair<Float, Float>) {
        val x = (pair.first / C).toInt()
        val y = ((pair.second - C) / C).toInt()
        val index = 3 * y + x
        if (queue) array[index] = 1
        else array[index] = 2
    }

    private fun findCoordinates() {
        for (i in array.indices) {
            if (array[i] != 0) {
                findCoordinates(i)
            }
        }
    }

    private fun findCoordinates(i: Int) {
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
    }

    private fun drawCircle(canvas: Canvas) {
        for (i in array.indices) {
            if (array[i] == 2) {
                canvas.drawCircle(pointX + B, pointY + B, B, circlePaint)
                queue = true
            }
        }
    }

    private fun drawCross(canvas: Canvas) {
        for (i in array.indices) {
            if (array[i] == 1) {
                drawLine(pointX, pointY, pointX + C, pointY + C, canvas, crossLinePaint)
                drawLine(pointX + C, pointY, pointX, pointY + C, canvas, crossLinePaint)
                queue = false
            }
        }
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