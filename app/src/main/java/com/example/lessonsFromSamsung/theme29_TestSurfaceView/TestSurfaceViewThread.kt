package com.example.lessonsFromSamsung.theme29_TestSurfaceView

import android.view.SurfaceHolder
import android.view.SurfaceView

class TestSurfaceViewThread(private val view: SurfaceView, private var surfaceHolder: SurfaceHolder) : Thread() {

    @Volatile
    var running = true

    fun requestStop() {
        running = false
    }

    override fun run() {
        while (running) {
            val canvas = surfaceHolder.lockCanvas() ?: continue

            try {
                view.draw(canvas)
            } finally {
                surfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }

}