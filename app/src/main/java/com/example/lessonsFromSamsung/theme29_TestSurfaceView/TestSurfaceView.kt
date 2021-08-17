package com.example.lessonsFromSamsung.theme29_TestSurfaceView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class TestSurfaceView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private var thread: TestSurfaceViewThread? = null

    private val backgroundPaint: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private val circlePaint: Paint = Paint().apply {
        isAntiAlias
        color = Color.CYAN
    }

    private var towardPointX = 0
    private var towardPointY = 0
    private var circleRadius = 0

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread = TestSurfaceViewThread(this, holder)
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        thread?.requestStop()

        var retry = true
        while (retry) {
            try {
                thread?.join()
                retry = false
            } catch (e: InterruptedException) {
            }
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        drawBackground(canvas)
        drawCircle(canvas)
        changeCircleRadius()
    }

    private fun drawBackground(canvas: Canvas) {
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
    }


    private fun drawCircle(canvas: Canvas) {
        canvas.drawCircle(towardPointX.toFloat(), towardPointY.toFloat(), circleRadius.toFloat(), circlePaint)
    }

    private fun changeCircleRadius() {
        if (circleRadius < 200) {
            circleRadius += 10
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            towardPointX = event.x.toInt()
            towardPointY = event.y.toInt()
            circleRadius = 0
        }
        return false
    }

}