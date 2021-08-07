package com.example.lessonsFromSamsung.theme28_SurfaceView

import android.view.SurfaceHolder
import android.view.SurfaceView

class DrawThread(private val view: SurfaceView, private var surfaceHolder: SurfaceHolder) : Thread() {

    @Volatile  // Позволяет не кэшировать переменные в разных потоках
    var running = true

    fun requestStop() { // Нужен для остановки run()
        running = false
    }

    override fun run() {
        while (running) {
            // LockCanvas() нужен, чтобы получить доступ к поверхности для рисования
            // Если   LockCanvas вернул Null -> continue
            val canvas = surfaceHolder.lockCanvas() ?: continue

            try {
                view.draw(canvas)
            } finally {  // Вызовется в любом случае, независимо от того, произойдет ошибка или нет
                surfaceHolder.unlockCanvasAndPost(canvas) // Парный с lockCanvas()
            }
        }
    }
}