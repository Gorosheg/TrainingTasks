package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.content.Context
import android.graphics.*
import android.view.View
import com.example.lessonsFromSamsung.R

class Example(context: Context?) : View(context) {

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
    private val circlePaint: Paint? = null
    private val text1Paint: Paint? = null
    private val text2Paint: Paint? = null
    private val image: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}