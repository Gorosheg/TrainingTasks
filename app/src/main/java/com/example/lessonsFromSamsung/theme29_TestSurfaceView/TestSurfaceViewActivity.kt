package com.example.lessonsFromSamsung.theme29_TestSurfaceView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestSurfaceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TestSurfaceView(this))
    }
}