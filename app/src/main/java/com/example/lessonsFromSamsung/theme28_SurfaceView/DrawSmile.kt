package com.example.lessonsFromSamsung.theme28_SurfaceView

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.lessonsFromSamsung.R

/* SurfaceHolder осуществляет доступ к поверхности для рисования
   С помощью Callback SurfaceHolder следит за тем,
   когда создается изменяется или удаляется поверхность для рисования*/
class DrawSmile(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private var thread: DrawThread? = null

    private val image: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.smile)
    private val backgroundPaint: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private var towardPointX = 0
    private var towardPointY = 0
    private var bitmapX = 0
    private var bitmapY = 0

    // Init блок вызывается сразу после унаследования от интерфейса
    init {
        // Holder дает доступ к колбэку
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread = DrawThread(this, holder)
        thread?.start() // Вызов жополнительного потока
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        thread?.requestStop() // Завершение дополнительного потока

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
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
        canvas.drawBitmap(image, bitmapX.toFloat(), bitmapY.toFloat(), backgroundPaint)

        if (bitmapX + image.width / 2 < towardPointX) bitmapX +=10
        if (bitmapX + image.width / 2 > towardPointX) bitmapX -=10
        if (bitmapY + image.height / 2 < towardPointY) bitmapY +=10
        if (bitmapY + image.height / 2 > towardPointY) bitmapY -=10
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            towardPointX = event.x.toInt()
            towardPointY = event.y.toInt()
        }
        return false
    }

}