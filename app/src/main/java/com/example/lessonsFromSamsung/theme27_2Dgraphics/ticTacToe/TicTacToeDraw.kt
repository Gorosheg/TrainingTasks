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
        drawCircle(canvas)
        drawCross(canvas)
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
        val x = pair.first / 2 * B
        val y = pair.second - B / B
        val index = 3 * x + y
        array[index.toInt()] = 1
    }

    private fun drawCircle(canvas: Canvas) {
        clicks.forEach { (x, y) ->
            canvas.drawCircle(x, y, 175F, circlePaint)
        }
    }

    private fun drawCross(canvas: Canvas) {
        drawLine(A, B, B, C, canvas, crossLinePaint)
        drawLine(B, B, A, C, canvas, crossLinePaint)
    }

    private fun drawGrid(canvas: Canvas) {
        drawLine(B, B, B, E, canvas, linePaint)
        drawLine(C, B, C, E, canvas, linePaint)
        drawLine(A, C, D, C, canvas, linePaint)
        drawLine(A, D, D, D, canvas, linePaint)
    }

    private fun drawLine(startX: Float, startY: Float, stopX: Float, stopY: Float, canvas: Canvas, linePaint: Paint) {
        canvas.drawLine(startX, startY, stopX, stopY, linePaint)
    }

    companion object {
        private const val A = 0f
        private const val B = 350f
        private const val C = 700f
        private const val D = 1050f
        private const val E = 1400f
    }

}