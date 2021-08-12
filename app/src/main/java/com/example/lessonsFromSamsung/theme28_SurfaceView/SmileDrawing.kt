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
class SmileDrawing(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private var threadForDrawing: ThreadForDrawing? = null

    private val imageGood: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.smile2)
    private val imageBad: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.smile1)

    private val backgroundPaint: Paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private var towardPointX = 0
    private var towardPointY = 0
    private var imageX = 0
    private var imageY = 0

    //  var count = true

    // Init блок вызывается сразу после унаследования от интерфейса
    init {
        // Holder дает доступ к колбэку
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        threadForDrawing = ThreadForDrawing(this, holder)
        threadForDrawing?.start() // Вызов дополнительного потока
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        threadForDrawing?.requestStop() // Завершение дополнительного потока

        var retry = true
        while (retry) {
            try {
                threadForDrawing?.join()
                retry = false
            } catch (e: InterruptedException) {
            }
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        drawBackground(canvas)
        drawImage(canvas)
        changeImagePosition()
    }

    private fun drawBackground(canvas: Canvas) {
        /* if (count) {
             backgroundPaint.color = Color.GREEN
             count = false
         } else {
             backgroundPaint.color = Color.BLUE
             count = true
         }*/
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)
    }

    private fun changeImagePosition() {

        //if (towardPointX < width / 2) {
        if (imageX + imageGood.width / 2 < towardPointX) imageX += 30
        if (imageX + imageGood.width / 2 > towardPointX) imageX -= 30
        if (imageY + imageGood.height / 2 < towardPointY) imageY += 10
        if (imageY + imageGood.height / 2 > towardPointY) imageY -= 10
        //  }
    }

    private fun drawImage(canvas: Canvas) {
        if (imageY < height / 2 - 150) {
            canvas.drawBitmap(imageGood, imageX.toFloat(), imageY.toFloat(), backgroundPaint)
        } else {
            canvas.drawBitmap(imageBad, imageX.toFloat(), imageY.toFloat(), backgroundPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            towardPointX = event.x.toInt()
            towardPointY = event.y.toInt()
        }
        return false
    }
}