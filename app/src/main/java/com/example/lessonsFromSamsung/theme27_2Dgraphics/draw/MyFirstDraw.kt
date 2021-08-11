package com.example.lessonsFromSamsung.theme27_2Dgraphics.draw

import android.content.Context
import android.graphics.*
import android.view.View
import com.example.lessonsFromSamsung.R

class MyFirstDraw(context: Context) : View(context) {

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
        textSize = 30F
    }

    private val text2Pint: Paint = Paint().apply {
        color = Color.BLACK
        textSize = 40F
    }

    private val image: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat)

    /**
     * canvas - холст для рисования
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawPaint(backGroundPaint)
        //(положение по горизонтали, положение по вертикали, радиус, ссылка на фигуру)
        canvas?.drawCircle(width / 2f, height / 2F, 100F, circlePaint)
        // (расстояние от левого края, расстояние от верхнего края, ширина, ссылка не фигуру)
        canvas?.drawRect(0F, 0F, width.toFloat(), 200F, rectPaint)
        //(текст, расстояние от левого края, расстояние от верхнего края, ссылка)
        canvas?.drawText("some text", 50F, 100F, text1Paint)

        //текст под углом
        val rotateCenterX = 200f // Центр поворота холста по оси Х
        val rotateCenterY = 200f // Центр поворота холста по оси У
        val rotateAngle = 45f // Угол поворота

        // Поворачиваем холст
        canvas?.rotate(-rotateAngle, rotateCenterX, rotateCenterY)

        canvas?.drawText("some text two", 0f, 450f, text2Pint)

        // Поворачиваем холст обратно
        canvas?.rotate(rotateAngle, rotateCenterX, rotateCenterY)

        val xx = width / 2 - image.width / 2
        val yy = height / 2 - image.height / 2

        canvas?.drawBitmap(image, xx.toFloat(), yy.toFloat(), backGroundPaint)
    }

}