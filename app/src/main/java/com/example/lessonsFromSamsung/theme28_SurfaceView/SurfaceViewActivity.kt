package com.example.lessonsFromSamsung.theme28_SurfaceView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SurfaceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawSmile(this))
    }
}