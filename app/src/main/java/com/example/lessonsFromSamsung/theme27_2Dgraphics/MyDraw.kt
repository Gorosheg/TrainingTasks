package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.*
import android.view.View
import com.example.lessonsFromSamsung.R

class MyDraw(context: Context) : View(context) {

    private val paint: Paint = Paint().apply {
        color = Color.RED
    }

    private val backGroundPaint: Paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }
    private val rectPaint: Paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLUE
    }
    private val circlePaint: Paint = Paint().apply {
        isAntiAlias
        color = Color.argb(127, 0, 0, 125)
    }
    private val text1Paint: Paint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        textSize = 30F                          //help
    }
    private val text2Pint: Paint = Paint().apply {
        color = Color.BLACK
        textSize = 40F
    }

    private val image: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground)

    /**
     * canvas - холст для рисования
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawPaint(backGroundPaint)
        canvas?.drawCircle(width / 2f, height / 2f, 100F, circlePaint)
        canvas?.drawRect(0F, 0F, width.toFloat(), 200F, rectPaint)
        canvas?.drawText("some text", 50F, 100F, text1Paint)
    }

}